package com.haotu369.tio.helloworld.common;

import org.tio.core.intf.Packet;

/**
 * 有时候服务器和客户端的业务消息包结构不一样，
 * 这种情况下，消息包的定义就不要放在公共模块中，而是在服务端和客户端分别定义
 *
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/29
 */
public class HelloPacket extends Packet {

    private static final long serialVersionUID = -6486577863211351905L;

    // 消息头的长度
    public static final int HEADER_LENGTH = 4;

    public static final String CHARSET = "UTF-8";

    // 消息体
    private byte[] body;

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}
