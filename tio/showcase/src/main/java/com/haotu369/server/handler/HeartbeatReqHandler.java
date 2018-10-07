package com.haotu369.server.handler;

import com.haotu369.common.intf.AbsShowcaseBsHandler;
import com.haotu369.common.packet.GroupMsgReqBody;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/9/13
 */
public class HeartbeatReqHandler extends AbsShowcaseBsHandler<GroupMsgReqBody> {

    public Class<GroupMsgReqBody> bodyClass() {
        return GroupMsgReqBody.class;
    }

    public void handler(Packet packet, GroupMsgReqBody bsBody, ChannelContext channelContext) {
        return ;
    }
}
