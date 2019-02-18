package online.shenjian.tio.im.common.http.websocket;

import online.shenjian.tio.im.common.ImPacket;
import online.shenjian.tio.im.common.packets.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/24
 */
public class WebSocketPacket extends ImPacket {

    public static enum Opcode {
        TEXT((byte)1), BINARY((byte)2), CLOSE((byte)8), PING((byte)9), PONG((byte)10);

        private static final Map<Byte, Opcode> map = new HashMap<>();
        private final byte code;

        static {
            for (Opcode command: values()) {
                map.put(command.getCode(), command);
            }
        }

        public static Opcode getOpcode(byte code) {
            return map.get(code);
        }

        private Opcode(byte code) {
            this.code = code;
        }

        public byte getCode() {
            return code;
        }
    }

    private boolean wsEof;
    private byte[] wsBody;
    private Opcode opcode;

    public WebSocketPacket(Command command) {
        super(command);
    }

    public WebSocketPacket(Command command, byte[] wsBody) {
        super(command, wsBody);
    }

    public boolean isWsEof() {
        return wsEof;
    }

    public void setWsEof(boolean wsEof) {
        wsEof = wsEof;
    }

    public byte[] getWsBody() {
        return wsBody;
    }

    public void setWsBody(byte[] wsBody) {
        this.wsBody = wsBody;
    }

    public Opcode getOpcode() {
        return opcode;
    }

    public void setOpcode(Opcode opcode) {
        this.opcode = opcode;
    }
}
