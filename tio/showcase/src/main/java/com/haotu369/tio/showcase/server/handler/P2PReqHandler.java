package com.haotu369.tio.showcase.server.handler;

import com.haotu369.tio.showcase.common.Const;
import com.haotu369.tio.showcase.common.ShowcasePacket;
import com.haotu369.tio.showcase.common.ShowcaseSessionContext;
import com.haotu369.tio.showcase.common.Type;
import com.haotu369.tio.showcase.common.intf.AbsShowcaseBsHandler;
import com.haotu369.tio.showcase.common.packet.P2PReqBody;
import com.haotu369.tio.showcase.common.packet.P2PRespBody;
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
public class P2PReqHandler extends AbsShowcaseBsHandler<P2PReqBody> {

    private static final Logger LOGGER = LoggerFactory.getLogger(P2PReqHandler.class);

    public Class<P2PReqBody> bodyClass() {
        return P2PReqBody.class;
    }

    public void handler(Packet packet, P2PReqBody bsBody, ChannelContext channelContext) {
        LOGGER.info("收到P2P的请求消息: {}", Json.toJson(bsBody));

        ShowcaseSessionContext showcaseSessionContext = (ShowcaseSessionContext) channelContext.getAttribute();

        P2PRespBody p2PRespBody = new P2PRespBody();
        p2PRespBody.setFromUserId(showcaseSessionContext.getUserId());
        p2PRespBody.setText(bsBody.getText());

        ShowcasePacket responsePacket = new ShowcasePacket();
        responsePacket.setType(Type.P2P_RESP);
        try {
            responsePacket.setBody(Json.toJson(p2PRespBody).getBytes(Const.CHARSET));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Tio.sendToUser(channelContext.getGroupContext(), bsBody.getToUserId(), responsePacket);
    }
}
