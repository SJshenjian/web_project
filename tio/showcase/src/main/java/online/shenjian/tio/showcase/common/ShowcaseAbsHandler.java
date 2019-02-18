package online.shenjian.tio.showcase.common;

import org.tio.core.ChannelContext;
import org.tio.core.GroupContext;
import org.tio.core.exception.AioDecodeException;
import org.tio.core.intf.AioHandler;
import org.tio.core.intf.Packet;

import java.nio.ByteBuffer;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/31
 */
public abstract class ShowcaseAbsHandler implements AioHandler {

    public Packet decode(ByteBuffer buffer, int limit, int position, int readableLength, ChannelContext channelContext) throws AioDecodeException {
        if (readableLength < ShowcasePacket.HEADER_LENGTH) {
            return null;
        }

        byte type = buffer.get();
        int bodyLength = buffer.getInt();
        if (bodyLength < 0) {
            throw new AioDecodeException("bodyLength [" + bodyLength + "] is not right; remote client : " + channelContext.getClientNode());
        }

        int allNeedLength = ShowcasePacket.HEADER_LENGTH + bodyLength;
        int isDataEnough = readableLength - allNeedLength;

        if (isDataEnough < 0) {
            return  null;
        }

        ShowcasePacket showcasePacket = new ShowcasePacket();
        showcasePacket.setType(type);
        if (bodyLength > 0) {
            byte[] dst = new byte[bodyLength];
            buffer.get(dst);
            showcasePacket.setBody(dst);
        }

        return showcasePacket;
    }

    public ByteBuffer encode(Packet packet, GroupContext groupContext, ChannelContext channelContext) {
        ShowcasePacket showcasePacket = (ShowcasePacket) packet;
        byte[] body = showcasePacket.getBody();
        int bodyLength = 0;

        if (body != null) {
            bodyLength = body.length;
        }

        int allLength = ShowcasePacket.HEADER_LENGTH + bodyLength;
        ByteBuffer byteBuffer = ByteBuffer.allocate(allLength);

        byteBuffer.order(groupContext.getByteOrder());
        byteBuffer.put(showcasePacket.getType());
        byteBuffer.putInt(bodyLength);
        if (body != null) {
            byteBuffer.put(body);
        }

        return byteBuffer;
    }
}
