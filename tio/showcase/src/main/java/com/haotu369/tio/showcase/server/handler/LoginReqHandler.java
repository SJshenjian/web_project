package com.haotu369.tio.showcase.server.handler;

import com.haotu369.tio.showcase.common.Const;
import com.haotu369.tio.showcase.common.ShowcasePacket;
import com.haotu369.tio.showcase.common.ShowcaseSessionContext;
import com.haotu369.tio.showcase.common.Type;
import com.haotu369.tio.showcase.common.intf.AbsShowcaseBsHandler;
import com.haotu369.tio.showcase.common.packet.LoginReqBody;
import com.haotu369.tio.showcase.common.packet.LoginRespBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.core.intf.Packet;
import org.tio.utils.json.Json;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public class LoginReqHandler extends AbsShowcaseBsHandler<LoginReqBody> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginReqHandler.class);

    private AtomicInteger tokenIndex = new AtomicInteger();

    public Class<LoginReqBody> bodyClass() {
        return LoginReqBody.class;
    }

    public void handler(Packet packet, LoginReqBody bsBody, ChannelContext channelContext) {
        LOGGER.info("收到登录的请求消息：{}", Json.toJson(bsBody));

        System.out.println("收到登录的请求消息：{}" + Json.toJson(bsBody));
        LoginRespBody loginRespBody = new LoginRespBody();
        loginRespBody.setCode(LoginRespBody.Code.SUCCESS);
        loginRespBody.setToken(buildToken());

        String userId = bsBody.getUsername();
        Tio.bindUser(channelContext, userId);

        ShowcaseSessionContext showcaseSessionContext = new ShowcaseSessionContext();
        showcaseSessionContext.setUserId(userId);

        ShowcasePacket responsePacket = new ShowcasePacket();
        responsePacket.setType(Type.LOGIN_RESP);
        try {
            responsePacket.setBody(Json.toJson(loginRespBody).getBytes(Const.CHARSET));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Tio.send(channelContext, responsePacket);
    }

    private String buildToken() {
        return System.currentTimeMillis() + "_" + tokenIndex.incrementAndGet();
    }
}
