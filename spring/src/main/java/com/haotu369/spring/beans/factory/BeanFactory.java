package com.haotu369.spring.beans.factory;

import com.haotu369.spring.beans.BeansDefinition;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/28
 */
public interface BeanFactory {

    BeansDefinition getBeanDefinition(String id);

    Object getBean(String id);
}
