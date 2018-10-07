package com.haotu369.tio.showcase.common.packet;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public class GroupMsgRespBody extends BaseBody {

    // 消息内容
    private String text;
    // 消息来源
    private String fromUserId;
    // 消息发往组
    private String toGroup;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToGroup() {
        return toGroup;
    }

    public void setToGroup(String toGroup) {
        this.toGroup = toGroup;
    }
}
