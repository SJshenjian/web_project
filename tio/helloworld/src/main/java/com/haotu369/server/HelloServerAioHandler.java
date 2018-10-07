package com.haotu369.server;

import com.haotu369.common.HelloPacket;
import org.tio.core.Aio;
import org.tio.core.ChannelContext;
import org.tio.core.GroupContext;
import org.tio.core.exception.AioDecodeException;
import org.tio.core.intf.Packet;
import org.tio.server.intf.ServerAioHandler;

import java.nio.ByteBuffer;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/29
 */
public class HelloServerAioHandler implements ServerAioHandler {


    public Packet decode(ByteBuffer byteBuffer, ChannelContext channelContext) throws AioDecodeException {
        int readableLength = byteBuffer.limit() - byteBuffer.position();
        // 检验可读的数据包长度是否满足消息头长度
        if (readableLength < HelloPacket.HEADER_LENGTH) {
            return null;
        }

        int bodyLength = byteBuffer.getInt();
        if (bodyLength < 0) {
            throw new AioDecodeException("bodyLength [" + bodyLength + "is not right, remote client : " + channelContext.getClientNode());
        }

        // 检验可读的数据包长度是否满足消息体长度
        int neededLength = HelloPacket.HEADER_LENGTH + bodyLength;
        int isDataEnough = readableLength - neededLength;
        if (isDataEnough < 0) {
            return null;
        }

        HelloPacket packet = new HelloPacket();
        if (bodyLength > 0) {
            byte[] body = new byte[bodyLength];
            byteBuffer.get(body);
            packet.setBody(body);
        }
        return packet;
    }

    /**
     * 编码：把业务消息包编码程可以发送的ByteBuffer
     * @param packet
     * @param groupContext
     * @param channelContext
     * @return
     */
    public ByteBuffer encode(Packet packet, GroupContext groupContext, ChannelContext channelContext) {
        HelloPacket helloPacket = (HelloPacket) packet;
        byte[] body = helloPacket.getBody();

        int bodyLength = 0;
        if (body != null) {
            bodyLength = body.length;
        }

        // byteBuffer总长度 = 消息头长度 + 消息体长度
        int allLength = HelloPacket.HEADER_LENGTH + bodyLength;
        ByteBuffer byteBuffer = ByteBuffer.allocate(allLength);

        // 设置字节序 大端模式、小端模式
        byteBuffer.order(groupContext.getByteOrder());
        // 写入消息头 消息头的信息是消息体的长度
        byteBuffer.putInt(bodyLength);
        // 写入消息体
        if (body != null) {
            byteBuffer.put(body);
        }

        return byteBuffer;
    }

    public void handler(Packet packet, ChannelContext channelContext) throws Exception {
        HelloPacket helloPacket = (HelloPacket) packet;
        byte[] receivedBytes = helloPacket.getBody();
        if (receivedBytes != null) {
            String message = new String(receivedBytes, HelloPacket.CHARSET);
            System.out.println("收到消息：" + message);
            String sendMessage = "收到了你的消息：" + message;
            HelloPacket clientPacket = new HelloPacket();
            clientPacket.setBody(sendMessage.getBytes(HelloPacket.CHARSET));

            Aio.send(channelContext, clientPacket);
        }
    }
}
