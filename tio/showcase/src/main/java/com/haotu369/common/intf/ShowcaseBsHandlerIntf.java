package com.haotu369.common.intf;

import com.haotu369.common.ShowcasePacket;
import org.tio.core.ChannelContext;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public interface ShowcaseBsHandlerIntf {

    void handler(ShowcasePacket packet, ChannelContext channelContext) throws Exception;
}
