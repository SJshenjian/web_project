package com.haotu369.spring.beans.factory.support;

import com.haotu369.spring.beans.BeansDefinition;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/28
 */
public class GenericBeanDefinition implements BeansDefinition {

    private String id;
    private String className;

    public GenericBeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    @Override
    public String getBeanClassName() {
        return className;
    }
}
