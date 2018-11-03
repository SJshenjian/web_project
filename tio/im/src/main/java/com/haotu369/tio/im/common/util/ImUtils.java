package com.haotu369.tio.im.common.util;

import com.haotu369.tio.im.common.ImSessionContext;
import com.haotu369.tio.im.common.http.HttpRequestPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/3
 */
public class ImUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImUtils.class);


    public static String formatUserAgent(ChannelContext channelContext) {
        ImSessionContext imSessionContext = (ImSessionContext) channelContext.getAttribute();
        HttpRequestPacket httpHandshakePacket = imSessionContext.getHttpHandshakePacket();
        if (httpHandshakePacket != null) {
            // TODO 暂缓实现
            return "";
        }
        return "";
    }
}
