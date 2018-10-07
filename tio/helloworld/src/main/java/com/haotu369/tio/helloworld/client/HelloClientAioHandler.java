package com.haotu369.tio.helloworld.client;

import com.haotu369.tio.helloworld.common.HelloPacket;
import org.tio.client.intf.ClientAioHandler;
import org.tio.core.ChannelContext;
import org.tio.core.GroupContext;
import org.tio.core.exception.AioDecodeException;
import org.tio.core.intf.Packet;

import java.nio.ByteBuffer;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/29
 */
public class HelloClientAioHandler implements ClientAioHandler {

    private static final HelloPacket heartPacket = new HelloPacket();

    // 如果返回null,框架层不会定时发心跳；非null,框架会定时发送本方法返回的消息包
    public Packet heartbeatPacket() {
        return heartPacket;
    }

    public Packet decode(ByteBuffer byteBuffer, ChannelContext channelContext) throws AioDecodeException {
        int readableLength = byteBuffer.limit() - byteBuffer.position();
        if (readableLength < HelloPacket.HEADER_LENGTH) {
            return null;
        }

        int bodyLength = byteBuffer.getInt();
        if (bodyLength < 0) {
            throw new AioDecodeException("bodyLength [" + bodyLength + "is not right, remote client : " + channelContext.getClientNode());
        }

        int neededLength = HelloPacket.HEADER_LENGTH + bodyLength;
        int isDataEnough = readableLength - neededLength;
        if (isDataEnough < 0) {
            return null;
        }

        HelloPacket packet = new HelloPacket();
        if (bodyLength > 0) {
            byte[] bytes = new byte[bodyLength];
            byteBuffer.get(bytes);
            packet.setBody(bytes);
        }

        return packet;
    }

    public ByteBuffer encode(Packet packet, GroupContext groupContext, ChannelContext channelContext) {
        HelloPacket helloPacket = (HelloPacket)packet;
        byte[] body = helloPacket.getBody();

        int bodyLength = 0;
        if (body != null) {
            bodyLength = body.length;
        }

        int allLength = HelloPacket.HEADER_LENGTH + bodyLength;
        ByteBuffer byteBuffer = ByteBuffer.allocate(allLength);

        byteBuffer.order(groupContext.getByteOrder());
        byteBuffer.putInt(bodyLength);
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
        }
    }
}
