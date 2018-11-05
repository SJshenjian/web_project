package com.haotu369.tio.im.server.server;

import com.haotu369.tio.im.common.ImSessionContext;
import com.haotu369.tio.im.common.http.websocket.WebSocketPacket;
import com.haotu369.tio.im.common.packets.Command;
import com.haotu369.tio.im.common.packets.ExitGroupNotifyRespBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.core.intf.GroupListener;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/3
 */
public class ImGroupListener implements GroupListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImGroupListener.class);

    @Override
    public void onAfterBind(ChannelContext channelContext, String group) throws Exception {

    }

    @Override
    public void onAfterUnbind(ChannelContext channelContext, String group) throws Exception {
        ImSessionContext imSessionContext = (ImSessionContext) channelContext.getAttribute();
        ExitGroupNotifyRespBody exitGroupNotifyRespBody =  ExitGroupNotifyRespBody.newBuilder().setGroup(group).setClient(imSessionContext.getClient()).build();
        WebSocketPacket webSocketPacket = new WebSocketPacket(Command.COMMAND_EXIT_GROUP_NOTIFY_RESP, exitGroupNotifyRespBody.toByteArray());
        Tio.sendToGroup(channelContext.getGroupContext(), group, webSocketPacket);
    }
}
