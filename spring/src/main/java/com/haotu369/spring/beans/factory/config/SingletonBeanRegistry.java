package com.haotu369.spring.beans.factory.config;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/21
 */
public interface SingletonBeanRegistry {

    void registrySingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);
}
