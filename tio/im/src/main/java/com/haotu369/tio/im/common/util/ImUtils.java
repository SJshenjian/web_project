package com.haotu369.tio.im.common.util;

import com.haotu369.tio.im.common.ImSessionContext;
import com.haotu369.tio.im.common.http.HttpRequestPacket;
import com.haotu369.tio.im.common.packets.Client;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;

import java.util.ArrayList;
import java.util.List;

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

    public static String formatRegion(String region) {
        if (StringUtils.isBlank(region)) {
            return "";
        }

        String[] arr = StringUtils.split(region, "|");//.split("|");
        List<String> validArr = new ArrayList<>();
        for (String element : arr) {
            String e = element;
            if (StringUtils.isNotBlank(e) && !"0".equals(e)) {
                validArr.add(e);
            }
        }
        if (validArr.size() == 0) {
            return "";
        }
        if (validArr.size() == 1) {
            return validArr.get(0);
        }
        return validArr.get(validArr.size() - 2) + validArr.get(validArr.size() - 1);
    }

    /**
     * 设置Client对象到ImSessionContext中
     *
     * @param channelContext
     * @return
     */
    public static Client setClient(ChannelContext channelContext) {
        ImSessionContext imSessionContext = (ImSessionContext) channelContext.getAttribute();
        Client client = imSessionContext.getClient();
        if (client == null) {
            Client.Builder builder = Client.newBuilder();
            builder.setId(channelContext.getId());
            builder.setIp(channelContext.getClientNode().getIp());
            builder.setPort(channelContext.getClientNode().getPort());

            if (imSessionContext.getDataBlock() != null) {
                builder.setRegion(imSessionContext.getDataBlock().getRegion());
            }
            client = builder.build();
            imSessionContext.setClient(client);
        }
        return client;
    }
}
