package com.haotu369.tio.showcase.server;

import com.haotu369.tio.showcase.common.Const;
import org.tio.server.ServerGroupContext;
import org.tio.server.TioServer;
import org.tio.server.intf.ServerAioHandler;
import org.tio.server.intf.ServerAioListener;

import java.io.IOException;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public class ShowcaseServerStarter {

    private static ServerAioHandler serverAioHandler = new ShowcaseServerAioHandler();
    private static ServerAioListener serverAioListener = new ShowcaseServerAioListener();
    private static ServerGroupContext serverGroupContext = new ServerGroupContext(serverAioHandler, serverAioListener);
    private static TioServer tioServer = new TioServer(serverGroupContext);
    private static String serverIp = null;
    private static int serverPort = Const.PORT;

    public static void main(String[] args) throws IOException {
        tioServer.start(serverIp, serverPort);
    }
}
