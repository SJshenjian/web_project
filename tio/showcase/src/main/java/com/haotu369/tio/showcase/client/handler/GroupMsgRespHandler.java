package com.haotu369.tio.showcase.client.handler;

import com.haotu369.tio.showcase.common.intf.AbsShowcaseBsHandler;
import com.haotu369.tio.showcase.common.packet.GroupMsgRespBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import org.tio.utils.json.Json;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public class GroupMsgRespHandler extends AbsShowcaseBsHandler<GroupMsgRespBody> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupMsgRespHandler.class);

    public Class<GroupMsgRespBody> bodyClass() {
        return GroupMsgRespBody.class;
    }

    public void handler(Packet packet, GroupMsgRespBody bsBody, ChannelContext channelContext) {
        LOGGER.info("收到群组消息：{}", Json.toJson(bsBody));
    }
}
