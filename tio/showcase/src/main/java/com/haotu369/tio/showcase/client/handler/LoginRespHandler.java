package com.haotu369.tio.showcase.client.handler;

import com.haotu369.tio.showcase.common.ShowcaseSessionContext;
import com.haotu369.tio.showcase.common.intf.AbsShowcaseBsHandler;
import com.haotu369.tio.showcase.common.packet.LoginRespBody;
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
public class LoginRespHandler extends AbsShowcaseBsHandler<LoginRespBody> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginRespHandler.class);

    public Class<LoginRespBody> bodyClass() {
        return LoginRespBody.class;
    }

    public void handler(Packet packet, LoginRespBody bsBody, ChannelContext channelContext) {
        LOGGER.info("收到登录的响应信息： {}", Json.toJson(bsBody));
        if (LoginRespBody.Code.SUCCESS.equals(bsBody.getCode())) {
            String token = bsBody.getToken();
            ShowcaseSessionContext showcaseSessionContext = (ShowcaseSessionContext) channelContext.getAttribute();
            showcaseSessionContext.setToken(token);
            LOGGER.info("登录成功，Token是:{}", token);
        }
    }
}
