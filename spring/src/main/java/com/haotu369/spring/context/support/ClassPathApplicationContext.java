package com.haotu369.spring.context.support;

import com.haotu369.spring.beans.factory.support.DefaultBeanFactory;
import com.haotu369.spring.beans.factory.xml.XMLBeanDefinitionReader;
import com.haotu369.spring.context.ApplicationContext;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/11
 */
public class ClassPathApplicationContext implements ApplicationContext {

    private DefaultBeanFactory defaultBeanFactory;
    private XMLBeanDefinitionReader xmlBeanDefinitionReader;

    public ClassPathApplicationContext(String file) {
        defaultBeanFactory = new DefaultBeanFactory();
        xmlBeanDefinitionReader = new XMLBeanDefinitionReader(defaultBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinition(file);
    }

    @Override
    public Object getBean(String id) {
        return defaultBeanFactory.getBean(id);
    }
}
