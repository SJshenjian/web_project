package online.shenjian.tio.im.server.server;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/3
 */
public class ImServerStarter {

    public static Config config = ConfigFactory.load("tio-im-server.conf");
}
