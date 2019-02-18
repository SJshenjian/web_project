package online.shenjian.tio.showcase.server;

import online.shenjian.tio.showcase.common.ShowcaseAbsHandler;
import online.shenjian.tio.showcase.common.ShowcasePacket;
import online.shenjian.tio.showcase.common.Type;
import online.shenjian.tio.showcase.common.intf.AbsShowcaseBsHandler;
import online.shenjian.tio.showcase.server.handler.GroupMsgReqHandler;
import online.shenjian.tio.showcase.server.handler.JoinGroupReqHandler;
import online.shenjian.tio.showcase.server.handler.LoginReqHandler;
import online.shenjian.tio.showcase.server.handler.P2PReqHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import org.tio.server.intf.ServerAioHandler;

import java.util.HashMap;
import java.util.Map;


/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public class ShowcaseServerAioHandler extends ShowcaseAbsHandler implements ServerAioHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShowcaseServerAioHandler.class);
    private static Map<Byte, AbsShowcaseBsHandler<?>> handlerMap = new HashMap<Byte, AbsShowcaseBsHandler<?>>();

    static {
        handlerMap.put(Type.LOGIN_REQ, new LoginReqHandler());
        handlerMap.put(Type.JOIN_GROUP_REQ, new JoinGroupReqHandler());
        handlerMap.put(Type.P2P_REQ, new P2PReqHandler());
        handlerMap.put(Type.GROUP_MSG_REQ, new GroupMsgReqHandler());
    }

    public void handler(Packet packet, ChannelContext channelContext) throws Exception {
        ShowcasePacket showcasePacket = (ShowcasePacket) packet;
        byte type = showcasePacket.getType();
        AbsShowcaseBsHandler<?> absShowcaseBsHandler = handlerMap.get(type);
        if (null == absShowcaseBsHandler ) {
            LOGGER.error("{},找不到处理类，type: {}", channelContext, type);
            return ;
        }
        absShowcaseBsHandler.handler(showcasePacket, channelContext);
    }
}
