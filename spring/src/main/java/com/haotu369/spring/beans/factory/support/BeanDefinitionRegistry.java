package com.haotu369.spring.beans.factory.support;

import com.haotu369.spring.beans.BeansDefinition;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/11
 */
public interface BeanDefinitionRegistry {

    BeansDefinition getBeanDefinition(String id);

    void registryBeanDefinition(String id, BeansDefinition beansDefinition);
}
