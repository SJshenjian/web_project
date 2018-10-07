package com.haotu369.server.handler;

import com.haotu369.common.Const;
import com.haotu369.common.ShowcasePacket;
import com.haotu369.common.Type;
import com.haotu369.common.intf.AbsShowcaseBsHandler;
import com.haotu369.common.packet.GroupMsgReqBody;
import com.haotu369.common.packet.JoinGroupReqBody;
import com.haotu369.common.packet.JoinGroupRespBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.core.intf.Packet;
import org.tio.utils.json.Json;

import java.io.UnsupportedEncodingException;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public class JoinGroupReqHandler extends AbsShowcaseBsHandler<JoinGroupReqBody> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupMsgReqBody.class);

    public Class<JoinGroupReqBody> bodyClass() {
        return JoinGroupReqBody.class;
    }

    public void handler(Packet packet, JoinGroupReqBody bsBody, ChannelContext channelContext) {
        LOGGER.info("收到进入群组的消息: {}", Json.toJson(bsBody));

        Tio.bindGroup(channelContext, bsBody.getGroup());

        JoinGroupRespBody joinGroupRespBody = new JoinGroupRespBody();
        joinGroupRespBody.setCode(JoinGroupRespBody.Code.SUCCESS);
        joinGroupRespBody.setGroup(bsBody.getGroup());

        ShowcasePacket responsePacket = new ShowcasePacket();
        responsePacket.setType(Type.JOIN_GROUP_RESP);
        try {
            responsePacket.setBody(Json.toJson(joinGroupRespBody).getBytes(Const.CHARSET));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Tio.send(channelContext, responsePacket);
    }
}
