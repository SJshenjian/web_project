package com.haotu369.tio.im.server.server;

import cn.hutool.core.util.ZipUtil;
import com.haotu369.tio.im.common.ImPacket;
import com.haotu369.tio.im.common.ImSessionContext;
import com.haotu369.tio.im.common.http.HttpResponseEncoder;
import com.haotu369.tio.im.common.http.HttpResponsePacket;
import com.haotu369.tio.im.common.http.websocket.WebSocketEncoder;
import com.haotu369.tio.im.common.http.websocket.WebSocketPacket;
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
        return null;
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
