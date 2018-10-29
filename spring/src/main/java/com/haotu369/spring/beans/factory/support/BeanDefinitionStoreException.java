package com.haotu369.spring.beans.factory.support;

import com.haotu369.spring.beans.BeansDefinition;
import com.haotu369.spring.beans.factory.BeansException;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/29
 */
public class BeanDefinitionStoreException extends BeansException {

    public BeanDefinitionStoreException(String message) {
        super(message);
    }

    public BeanDefinitionStoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
