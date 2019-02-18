package online.shenjian.tio.showcase.common;

import org.tio.core.intf.Packet;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public class ShowcasePacket extends Packet {

    private static final long serialVersionUID = 5964025697319179964L;

    public static final int HEADER_LENGTH = 5;

    private byte type;
    private byte[] body;

    public ShowcasePacket() {
        super();
    }

    public ShowcasePacket(byte type, byte[] body) {
        this.type = type;
        this.body = body;
    }

    @Override
    public String logstr() {
        return "" + type;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}
