package online.shenjian.tio.im.server.server.handler;

import online.shenjian.tio.im.common.ImPacket;
import org.tio.core.ChannelContext;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/24
 */
public interface ImBsHandlerIntf {

    public Object handler(ImPacket imPacket, ChannelContext channelContext) throws Exception;
}
