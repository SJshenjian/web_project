package online.shenjian.tio.showcase.client.handler;

import online.shenjian.tio.showcase.common.intf.AbsShowcaseBsHandler;
import online.shenjian.tio.showcase.common.packet.P2PRespBody;
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
public class P2PRespHandler extends AbsShowcaseBsHandler<P2PRespBody> {

    private static final Logger LOGGER = LoggerFactory.getLogger(P2PRespHandler.class);

    public Class<P2PRespBody> bodyClass() {
        return P2PRespBody.class;
    }

    public void handler(Packet packet, P2PRespBody bsBody, ChannelContext channelContext) {
        LOGGER.info("收到P2P响应消息: {}", Json.toJson(bsBody));
    }
}
