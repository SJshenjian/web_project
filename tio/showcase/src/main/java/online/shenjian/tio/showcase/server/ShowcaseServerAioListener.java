package online.shenjian.tio.showcase.server;

import online.shenjian.tio.showcase.common.ShowcaseSessionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import org.tio.server.intf.ServerAioListener;
import org.tio.utils.json.Json;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public class ShowcaseServerAioListener implements ServerAioListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShowcaseServerAioListener.class);

    public void onAfterConnected(ChannelContext channelContext, boolean isConnected, boolean isReconnect) throws Exception {
        LOGGER.info("onAfterConnected channelContext:{}, isConnected:{}, isReconnect:{}", channelContext, isConnected, isReconnect);

        //连接后，需要把连接会话对象设置给channelContext
        channelContext.setAttribute(new ShowcaseSessionContext());
    }

    public void onAfterDecoded(ChannelContext channelContext, Packet packet, int packetSize) throws Exception {

    }

    public void onAfterReceivedBytes(ChannelContext channelContext, int receivedBytes) throws Exception {

    }

    public void onAfterSent(ChannelContext channelContext, Packet packet, boolean isSentSuccess) throws Exception {
        LOGGER.info("onAfterSent channelContext:{}, packet:{}, isSentSuccess:{}", channelContext, Json.toJson(packet), isSentSuccess);
    }

    public void onAfterHandled(ChannelContext channelContext, Packet packet, long cost) throws Exception {

    }

    public void onBeforeClose(ChannelContext channelContext, Throwable throwable, String remark, boolean isRemove) throws Exception {

    }
}
