package com.haotu369.tio.showcase.common.packet;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public class GroupMsgReqBody extends BaseBody {

    // 消息内容
    private String text;
    // 发往的组
    private String toGroup;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getToGroup() {
        return toGroup;
    }

    public void setToGroup(String toGroup) {
        this.toGroup = toGroup;
    }
}
