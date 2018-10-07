package com.haotu369.common;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/31
 */
public interface Type {

    byte LOGIN_REQ = 1;

    byte LOGIN_RESP = 2;

    byte JOIN_GROUP_REQ = 3;

    byte JOIN_GROUP_RESP = 4;

    byte P2P_REQ = 5;

    byte P2P_RESP = 6;

    byte GROUP_MSG_REQ = 7;

    byte GROUP_MSG_RESP = 8;

    byte HEART_BEAT_REQ = 99;
}
