package online.shenjian.tio.im.common;

import online.shenjian.lionsoul.ip2region.DataBlock;
import online.shenjian.tio.im.common.http.HttpRequestPacket;
import online.shenjian.tio.im.common.packets.Client;
import org.tio.monitor.RateLimiterWrap;

import java.util.List;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/24
 */
public class ImSessionContext {

    /**
     * 消息请求频率过滤器
     */
    private RateLimiterWrap rateLimiterWrap;

    /**
     * 是否已经握过手
     */
    private boolean handshake;

    /**
     * IP所在地址信息
     */
    private DataBlock dataBlock;

    /**
     * 是否走了webSocket协议
     */
    private boolean webSocket;

    /**
     * webSocket握手包
     */
    private HttpRequestPacket httpHandshakePacket;

    private Client client;

    private String token;

    /**
     * webSocket协议所用，有时候数据包分几个到，注意fin字段，本im暂不支持
     */
    private List<byte[]> lastParts;

    public RateLimiterWrap getRateLimiterWrap() {
        return rateLimiterWrap;
    }

    public void setRateLimiterWrap(RateLimiterWrap rateLimiterWrap) {
        this.rateLimiterWrap = rateLimiterWrap;
    }

    public boolean isHandshake() {
        return handshake;
    }

    public void setHandshake(boolean handshake) {
        this.handshake = handshake;
    }

    public DataBlock getDataBlock() {
        return dataBlock;
    }

    public void setDataBlock(DataBlock dataBlock) {
        this.dataBlock = dataBlock;
    }

    public boolean isWebSocket() {
        return webSocket;
    }

    public void setWebSocket(boolean webSocket) {
        this.webSocket = webSocket;
    }

    public HttpRequestPacket getHttpHandshakePacket() {
        return httpHandshakePacket;
    }

    public void setHttpHandshakePacket(HttpRequestPacket httpHandshakePacket) {
        this.httpHandshakePacket = httpHandshakePacket;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<byte[]> getLastParts() {
        return lastParts;
    }

    public void setLastParts(List<byte[]> lastParts) {
        this.lastParts = lastParts;
    }
}
