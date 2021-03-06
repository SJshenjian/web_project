package online.shenjian.tio.showcase.client;

import online.shenjian.tio.showcase.client.handler.GroupMsgRespHandler;
import online.shenjian.tio.showcase.client.handler.JoinGroupRespHandler;
import online.shenjian.tio.showcase.client.handler.LoginRespHandler;
import online.shenjian.tio.showcase.client.handler.P2PRespHandler;
import online.shenjian.tio.showcase.common.ShowcaseAbsHandler;
import online.shenjian.tio.showcase.common.ShowcasePacket;
import online.shenjian.tio.showcase.common.Type;
import online.shenjian.tio.showcase.common.intf.AbsShowcaseBsHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.client.intf.ClientAioHandler;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public class ShowcaseClientAioHandler extends ShowcaseAbsHandler implements ClientAioHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShowcaseClientAioHandler.class);
    private static Map<Byte, AbsShowcaseBsHandler<?>> handlerMap = new HashMap<Byte, AbsShowcaseBsHandler<?>>();
    private static ShowcasePacket heartbeatPacket = new ShowcasePacket(Type.HEART_BEAT_REQ, null);

    static {
        handlerMap.put(Type.LOGIN_RESP, new LoginRespHandler());
        handlerMap.put(Type.JOIN_GROUP_RESP, new JoinGroupRespHandler());
        handlerMap.put(Type.P2P_RESP, new P2PRespHandler());
        handlerMap.put(Type.GROUP_MSG_RESP, new GroupMsgRespHandler());
    }

    public void handler(Packet packet, ChannelContext channelContext) throws Exception {
        ShowcasePacket showcasePacket = (ShowcasePacket) packet;
        byte type = showcasePacket.getType();
        AbsShowcaseBsHandler<?> absShowcaseBsHandler = handlerMap.get(type);
        if (null == absShowcaseBsHandler) {
            LOGGER.error("{},找不到处理类，type: {}", channelContext, type);
            return ;
        }
        absShowcaseBsHandler.handler(showcasePacket, channelContext);
    }

    public Packet heartbeatPacket() {
        return heartbeatPacket;
    }
}
