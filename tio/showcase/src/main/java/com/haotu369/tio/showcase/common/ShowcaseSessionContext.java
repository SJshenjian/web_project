package com.haotu369.tio.showcase.common;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/31
 */
public class ShowcaseSessionContext {

    private String userId;
    private String token;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
