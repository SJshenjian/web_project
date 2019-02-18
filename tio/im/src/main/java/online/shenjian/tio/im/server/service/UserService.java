package online.shenjian.tio.im.server.service;

import online.shenjian.tio.im.common.packets.Client;
import online.shenjian.tio.im.common.packets.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/3
 */
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    /**
     * 获取系统管理员Client对象
     * @return
     */
    public static Client getSysClient() {
        Client.Builder clientBuilder = Client.newBuilder();

        clientBuilder.setId("x");
        clientBuilder.setIp("0.0.0.0");
        clientBuilder.setPort(1314);
        clientBuilder.setRegion("保密");

        User.Builder userBuilder = User.newBuilder();
        userBuilder.setNickname("多米");
        userBuilder.setAvatar("");
        userBuilder.setId(-1);
        User user = userBuilder.build();
        clientBuilder.setUser(user);

        return clientBuilder.build();
    }
}
