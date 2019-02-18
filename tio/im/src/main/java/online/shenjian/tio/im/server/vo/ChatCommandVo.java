package online.shenjian.tio.im.server.vo;

import online.shenjian.tio.im.common.packets.Client;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/22
 */
public class ChatCommandVo {

    private String initText;
    private String  afterText;
    private boolean privateChat = true;
    private boolean command = true;

    private Client fromClient;

    public String getInitText() {
        return initText;
    }

    public void setInitText(String initText) {
        this.initText = initText;
    }

    public String getAfterText() {
        return afterText;
    }

    public void setAfterText(String afterText) {
        this.afterText = afterText;
    }

    public boolean isPrivateChat() {
        return privateChat;
    }

    public void setPrivateChat(boolean privateChat) {
        this.privateChat = privateChat;
    }

    public boolean isCommand() {
        return command;
    }

    public void setCommand(boolean command) {
        this.command = command;
    }

    public Client getFromClient() {
        return fromClient;
    }

    public void setFromClient(Client fromClient) {
        this.fromClient = fromClient;
    }
}
