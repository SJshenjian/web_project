package online.shenjian.tio.showcase.common.intf;

import online.shenjian.tio.showcase.common.ShowcasePacket;
import org.tio.core.ChannelContext;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public interface ShowcaseBsHandlerIntf {

    void handler(ShowcasePacket packet, ChannelContext channelContext) throws Exception;
}
