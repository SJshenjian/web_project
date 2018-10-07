package com.haotu369.tio.helloworld.server;

import com.haotu369.tio.helloworld.common.Const;
import org.tio.server.AioServer;
import org.tio.server.ServerGroupContext;
import org.tio.server.intf.ServerAioHandler;
import org.tio.server.intf.ServerAioListener;

import java.io.IOException;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/29
 */
public class HelloServerStarter {

    public static ServerAioHandler serverAioHandler = new HelloServerAioHandler();

    public static ServerAioListener serverAioListener = null;

    public static ServerGroupContext serverGroupContext = new ServerGroupContext(serverAioHandler, serverAioListener);

    public static AioServer aioServer = new AioServer(serverGroupContext);

    public static String serverIp = null;

    public static int serverPort = Const.PORT;

    public static void main(String[] args) throws IOException {
        serverGroupContext.setHeartbeatTimeout(Const.TIME_OUT);
        aioServer.start(serverIp, serverPort);
    }
}
