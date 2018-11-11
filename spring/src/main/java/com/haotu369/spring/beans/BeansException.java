package com.haotu369.spring.beans;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/29
 */
public class BeansException extends RuntimeException  {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
