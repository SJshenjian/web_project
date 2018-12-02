package com.haotu369.spring.beans.factory.config;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/2
 */
public class RuntimeBeanReference {

    private final String beanName;

    public RuntimeBeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
