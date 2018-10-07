package com.haotu369.tio.showcase.common.packet;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public class BaseBody {

    // 消息发送的时间
    private Long time = System.currentTimeMillis();

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
