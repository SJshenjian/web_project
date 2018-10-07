package com.haotu369.tio.showcase.server.handler;

import com.haotu369.tio.showcase.common.Const;
import com.haotu369.tio.showcase.common.ShowcasePacket;
import com.haotu369.tio.showcase.common.Type;
import com.haotu369.tio.showcase.common.intf.AbsShowcaseBsHandler;
import com.haotu369.tio.showcase.common.packet.GroupMsgReqBody;
import com.haotu369.tio.showcase.common.packet.GroupMsgRespBody;
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
public class GroupMsgReqHandler extends AbsShowcaseBsHandler<GroupMsgReqBody> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupMsgReqBody.class);

    public Class<GroupMsgReqBody> bodyClass() {
        return GroupMsgReqBody.class;
    }

    public void handler(Packet packet, GroupMsgReqBody bsBody, ChannelContext channelContext){
        LOGGER.info("收到群聊请求消息: {}", Json.toJson(bsBody));

        GroupMsgRespBody groupMsgRespBody = new GroupMsgRespBody();
        groupMsgRespBody.setText(bsBody.getText());
        groupMsgRespBody.setToGroup(bsBody.getToGroup());

        ShowcasePacket responsePacket = new ShowcasePacket();
        responsePacket.setType(Type.GROUP_MSG_RESP);
        try {
            responsePacket.setBody(Json.toJson(groupMsgRespBody).getBytes(Const.CHARSET));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Tio.sendToGroup(channelContext.getGroupContext(), bsBody.getToGroup(), responsePacket);
    }
}
