package com.haotu369.tio.showcase.client.handler;

import com.haotu369.tio.showcase.common.intf.AbsShowcaseBsHandler;
import com.haotu369.tio.showcase.common.packet.JoinGroupRespBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.core.intf.Packet;
import org.tio.utils.json.Json;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public class JoinGroupRespHandler extends AbsShowcaseBsHandler<JoinGroupRespBody> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupMsgRespHandler.class);

    public Class bodyClass() {
        return JoinGroupRespBody.class;
    }

    public void handler(Packet packet, JoinGroupRespBody bsBody, ChannelContext channelContext) {
        LOGGER.info("收到进去群组响应消息：{}", Json.toJson(bsBody));
        if (JoinGroupRespBody.Code.SUCCESS.equals(bsBody.getCode())) {
            Tio.bindGroup(channelContext, bsBody.getGroup());
            LOGGER.info("进去群组 {} 成功", bsBody.getGroup());
        }
    }
}
