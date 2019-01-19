package com.haotu369.spring.beans.factory.support;

import com.haotu369.spring.beans.BeanDefinition;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/19
 */
public interface BeanNameGenerator {

    String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry);
}
