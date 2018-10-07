package com.haotu369.common.packet;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public class LoginRespBody extends BaseBody {

    public static interface Code {
        Integer SUCCESS = 1;
        Integer FAIL = -1;
    }

    private String token;
    private Integer code;
    private String note;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
