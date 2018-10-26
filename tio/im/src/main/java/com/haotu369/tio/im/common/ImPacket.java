package com.haotu369.tio.im.common;

import com.haotu369.tio.im.common.packets.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.intf.Packet;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/24
 */
public class ImPacket extends Packet {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImPacket.class);

    /**
     * 心跳字节
     */
    public static final byte HEARTBEAT_BYTE = -128;

    /**
     * 握手字节
     */
    public static final byte HANDSHAKE_BYTE = -127;

    /**
     * 协议版本号
     */
    public static final byte VERSION = 1;

    /**
     * TODO ???
     * 消息头最少字节数
     */
    public static final int LEAST_HEADER_LENGTH = 4;

    /**
     * 压缩标识位mask, 1为压缩，否则不压缩
     */
    public static final byte FIRST_BYTE_MASK_COMPRESS = 0B01000000;


    /**
     * 同步序列号标识位mask, 如果有，消息头则会带同步序列号，否则不带
     */
    public static final byte FIRST_BYTE_MASK_HAS_SYNSEQ = 0B00100000;


    /**
     * 是否用4字节表示消息体的长度
     */
    public static final byte FIRST_BYTE_MASK_4_BYTE_LENGTH = 0B0010000;

    public static byte encodeCompress(byte bs, boolean isCompress) {
        if (isCompress) {
            return (byte) (bs | FIRST_BYTE_MASK_COMPRESS);
        }
        return (byte) (bs & (FIRST_BYTE_MASK_COMPRESS ^ 0B01111111));
    }

    public static byte encodeHasSynSeq(byte bs, boolean hasSynSeq) {
        if (hasSynSeq) {
            return (byte) (bs | FIRST_BYTE_MASK_HAS_SYNSEQ);
        }
        return (byte) (bs & (FIRST_BYTE_MASK_HAS_SYNSEQ ^ 0B01111111));
    }

    public static byte encode4ByteLength(byte bs, boolean is4ByteLength) {
        if (is4ByteLength) {
            return (byte) (bs | FIRST_BYTE_MASK_4_BYTE_LENGTH);
        }
        return (byte) (bs & (FIRST_BYTE_MASK_4_BYTE_LENGTH ^ 0B01111111));
    }

    private Command command;
    private byte[] body;

    /**
     * 计算消息头占用的字节数
     *
     * @param is4ByteLength 是否用4字节来表示消息体的长度，false:2字节，true:4字节
     * @return
     */
    public int countHeaderLength(boolean is4ByteLength) {
        int length = LEAST_HEADER_LENGTH;
        if (is4ByteLength) {
            length += 2;
        }

        // 是否带有同步序列号
        if (this.getSynSeq() > 0) {
            length += 4;
        }

        return length;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}
