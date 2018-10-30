package com.haotu369.tio.im.server.server;

import cn.hutool.core.util.ZipUtil;
import com.haotu369.tio.im.common.ImPacket;
import com.haotu369.tio.im.common.ImSessionContext;
import com.haotu369.tio.im.common.http.HttpRequestDecoder;
import com.haotu369.tio.im.common.http.HttpRequestPacket;
import com.haotu369.tio.im.common.http.HttpResponseEncoder;
import com.haotu369.tio.im.common.http.HttpResponsePacket;
import com.haotu369.tio.im.common.http.websocket.WebSocketDecoder;
import com.haotu369.tio.im.common.http.websocket.WebSocketEncoder;
import com.haotu369.tio.im.common.http.websocket.WebSocketPacket;
import com.haotu369.tio.im.common.http.websocket.WebSocketPacket.Opcode;
import com.haotu369.tio.im.common.packets.Command;
import com.haotu369.tio.im.server.server.handler.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.GroupContext;
import org.tio.core.exception.AioDecodeException;
import org.tio.core.intf.Packet;
import org.tio.server.intf.ServerAioHandler;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/24
 */
public class ImAioServerHandler implements ServerAioHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImAioServerHandler.class);
    private static Map<Command, ImBsHandlerIntf> handlerMap = new HashMap<>();

    static {
        handlerMap.put(Command.COMMAND_HANDSHAKE_REQ, new HandshakeReqHandler());
        handlerMap.put(Command.COMMAND_CHAT_REQ, new ChatReqHandler());
        handlerMap.put(Command.COMMAND_JOIN_GROUP_REQ, new JoinGroupReqHandler());
        handlerMap.put(Command.COMMAND_HEARTBEAT_REQ, new HeartbeatReqHandler());
        handlerMap.put(Command.COMMAND_CLOSE_REQ, new CloseReqHandler());

        handlerMap.put(Command.COMMAND_LOGIN_REQ, new LoginReqHandler());
        handlerMap.put(Command.COMMAND_CLIENT_PAGE_REQ, new ClientPageReqHandler());
    }

    /**
     * 心跳
     */
    private static WebSocketPacket heartbeatPacket = new WebSocketPacket(Command.COMMAND_HEARTBEAT_REQ);

    /**
     * 握手
     */
    private static WebSocketPacket handshakePacket = new WebSocketPacket(Command.COMMAND_HANDSHAKE_REQ);

    @Override
    public Packet decode(ByteBuffer buffer, int limit, int position, int readableLength, ChannelContext channelContext) throws AioDecodeException {
        ImSessionContext imSessionContext = (ImSessionContext) channelContext.getAttribute();
        int initPosition = position;
        byte firstByte = buffer.get(initPosition);

        if (!imSessionContext.isHandshake()) {
            if (ImPacket.HANDSHAKE_BYTE == firstByte) {
                buffer.position(initPosition + 1);
                return handshakePacket;
            } else {
                HttpRequestPacket requestPacket = HttpRequestDecoder.decode(buffer, channelContext);
                if (requestPacket == null) {
                    return null;
                }

                requestPacket.setCommand(Command.COMMAND_HANDSHAKE_REQ);
                imSessionContext.setHttpHandshakePacket(requestPacket);
                imSessionContext.setWebSocket(true);
                return requestPacket;
            }
        }

        boolean isWebSocket = imSessionContext.isWebSocket();
        if (isWebSocket) {
            WebSocketPacket webSocketPacket = WebSocketDecoder.decode(buffer, channelContext);
            if (webSocketPacket == null) {
                return null;
            }

            if (!webSocketPacket.isWsEof()) {
                LOGGER.error("{} WebSocket包还没有传完", channelContext);
                return null;
            }

            Opcode opcode = webSocketPacket.getOpcode();
            if (Opcode.BINARY == opcode) {
                byte[] body = webSocketPacket.getWsBody();
                if (body == null || body.length <= 0) {
                    throw new AioDecodeException("错误的WebSocket包，body为空");
                }

                Command command = Command.forNumber(body[0]);
                WebSocketPacket imPacket = new WebSocketPacket(command);

                if (body.length > 1) {
                    byte[] dst = new byte[body.length - 1];
                    System.arraycopy(body, 1, dst, 0,body.length -1);
                    imPacket.setWsBody(dst);
                }
                return imPacket;
            } else if (Opcode.PING == opcode || Opcode.PONG == opcode) {
                return heartbeatPacket;
            } else if (Opcode.CLOSE == opcode) {
                WebSocketPacket imPacket = new WebSocketPacket(Command.COMMAND_CLOSE_REQ);
                return imPacket;
            } else if (Opcode.TEXT == opcode) {
                throw new AioDecodeException("错误的WebSocket包，不支持Text类型的数据");
            } else {
                throw new AioDecodeException("错误的WebSocket包，错误的Opcode");
            }
        } else {
            if (ImPacket.HEARTBEAT_BYTE == firstByte) {
                buffer.position(initPosition + 1);
                return heartbeatPacket;
            }
        }

        firstByte = buffer.get();

        boolean isCompress = ImPacket.decodeCompress(firstByte);
        boolean isHasSynSeq = ImPacket.decodeHasSynSeq(firstByte);
        boolean is4ByteLength = ImPacket.decode4ByteLength(firstByte);

        // 计算消息头长度
        int headerLength = ImPacket.LEAST_HEADER_LENGTH;
        if (isHasSynSeq) {
            headerLength += 4;
        }
        if (is4ByteLength) {
            headerLength += 2;
        }

        if (readableLength < headerLength) {
            return null;
        }

        // 取命令，此顺序不可变
        byte code = buffer.get();
        Command command = Command.forNumber(code);

        // 计算消息体长度
        int bodyLength = 0;
        if (is4ByteLength) {
            bodyLength = buffer.getInt();
        } else {
            bodyLength = buffer.getShort();
        }

        if (bodyLength > ImPacket.MAX_LENGTH_OF_BODY || bodyLength < 0) {
            throw new AioDecodeException("bodyLength [" + bodyLength + "] is not right, remote:" + channelContext.getClientNode());
        }

        int neededLength = headerLength + bodyLength;
        if (neededLength - readableLength < 0) {
            return null;
        }

        WebSocketPacket imPacket = new WebSocketPacket(command);

        // 取同步序列号
        if (isHasSynSeq) {
            int seq = buffer.getInt();
            if (seq > 0) {
                imPacket.setSynSeq(seq);
            }
        }

        if (bodyLength > 0) {
            byte[] dst = new byte[bodyLength];
            buffer.get(dst);
            if (isCompress) {
                try {
                    byte[] unzipByte = ZipUtil.unGzip(dst);
                    imPacket.setBody(unzipByte);
                } catch (Exception e) {
                    throw new AioDecodeException(e);
                }
            } else {
                imPacket.setBody(dst);
            }
        }

        return imPacket;
    }

    @Override
    public ByteBuffer encode(Packet packet, GroupContext groupContext, ChannelContext channelContext) {
        ImPacket imPacket = (ImPacket) packet;
        ImSessionContext imSessionContext = (ImSessionContext) channelContext.getAttribute();

        boolean isWebSocket = imSessionContext.isWebSocket();
        if (imPacket.getCommand() == Command.COMMAND_HANDSHAKE_RESP) {
            if (isWebSocket) {
                return HttpResponseEncoder.encode((HttpResponsePacket) packet, groupContext, channelContext);
            }
            ByteBuffer byteBuffer = ByteBuffer.allocate(1);
            byteBuffer.put(ImPacket.HANDSHAKE_BYTE);
            return byteBuffer;
        }

        if (isWebSocket) {
            return WebSocketEncoder.encoder((WebSocketPacket) packet, groupContext, channelContext);
        }

        byte[] body = imPacket.getBody();
        int bodyLen = 0;
        boolean isCompress = false;
        boolean is4ByteLength = false;

        if (body != null) {
            bodyLen = body.length;
            if (bodyLen > 300) {
                try {
                    byte[] gzipBody = ZipUtil.gzip(body);
                    if (gzipBody.length < bodyLen) {
                        LOGGER.info("压缩前 {}， 压缩后 {}", body.length, gzipBody.length);
                        body = gzipBody;
                        bodyLen = gzipBody.length;
                        isCompress = true;
                    }
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
            if (bodyLen > Short.MAX_VALUE) {
                is4ByteLength = true;
            }
        }

        int allLength = imPacket.countHeaderLength(is4ByteLength) + bodyLen;

        ByteBuffer byteBuffer = ByteBuffer.allocate(allLength);
        byteBuffer.order(groupContext.getByteOrder());

        byte firstByte = ImPacket.encodeCompress(ImPacket.VERSION, isCompress);
        firstByte = ImPacket.encodeHasSynSeq(firstByte, imPacket.getSynSeq() > 0);
        firstByte = ImPacket.encode4ByteLength(firstByte, is4ByteLength);

        // 该字节中表示内容丰富，包含是否压缩、是否带有同步序列号、是否用4字节表示消息体的长度
        byteBuffer.put(firstByte);
        byteBuffer.put((byte) imPacket.getCommand().getNumber());

        if (is4ByteLength) {
            byteBuffer.putInt(bodyLen);
        } else {
            byteBuffer.putShort((short) bodyLen);
        }

        if (imPacket.getSynSeq() > 0) {
            byteBuffer.putInt(imPacket.getSynSeq());
        }

        if (body != null) {
            byteBuffer.put(body);
        }
        return byteBuffer;
    }

    @Override
    public void handler(Packet packet, ChannelContext channelContext) throws Exception {

    }
}
