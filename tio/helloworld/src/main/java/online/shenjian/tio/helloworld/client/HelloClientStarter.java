package online.shenjian.tio.helloworld.client;

import online.shenjian.tio.helloworld.common.Const;
import online.shenjian.tio.helloworld.common.HelloPacket;
import org.tio.client.AioClient;
import org.tio.client.ClientChannelContext;
import org.tio.client.ClientGroupContext;
import org.tio.client.ReconnConf;
import org.tio.client.intf.ClientAioHandler;
import org.tio.client.intf.ClientAioListener;
import org.tio.core.Aio;
import org.tio.core.Node;

import java.io.UnsupportedEncodingException;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/29
 */
public class HelloClientStarter {

    public static ClientAioHandler clientAioHandler = new HelloClientAioHandler();

    public static ClientAioListener clientAioListener = null;

    // 断链重连时间，null表示不重连
    public static ReconnConf reconnConf = new ReconnConf(Const.TIME_OUT);

    public static ClientGroupContext clientGroupContext = new ClientGroupContext(clientAioHandler, clientAioListener, reconnConf);

    public static AioClient aioClient = null;

    public static ClientChannelContext clientChannelContext = null;

    public static Node serverNode = new Node(Const.SERVER, Const.PORT);

    public static void main(String[] args) throws Exception {
        clientGroupContext.setHeartbeatTimeout(Const.TIME_OUT);
        aioClient = new AioClient(clientGroupContext);
        clientChannelContext = aioClient.connect(serverNode);
        send();
    }

    private static void send() throws UnsupportedEncodingException {
        HelloPacket packet = new HelloPacket();
        packet.setBody("山猫山猫，我是白兔".getBytes(HelloPacket.CHARSET));
        Aio.send(clientChannelContext, packet);
    }
}
