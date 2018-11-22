package com.haotu369.spring.beans.factory.config;

import com.haotu369.spring.beans.factory.BeanFactory;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/16
 */
public interface ConfigurableBeanFactory extends BeanFactory {

    void setBeanClassLoader(ClassLoader classLoader);

    ClassLoader getBeanClassLoader();
}
