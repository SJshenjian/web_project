package com.haotu369.spring.context.support;

import com.haotu369.spring.beans.factory.support.DefaultBeanFactory;
import com.haotu369.spring.beans.factory.xml.XMLBeanDefinitionReader;
import com.haotu369.spring.context.ApplicationContext;
import com.haotu369.spring.core.io.Resource;
import com.haotu369.spring.util.ClassUtils;

/**
 * 模板方法
 *
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/16
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    private DefaultBeanFactory defaultBeanFactory;
    private XMLBeanDefinitionReader xmlBeanDefinitionReader;
    private ClassLoader classLoader;

    public abstract Resource getResourceByPath(String path);

    public AbstractApplicationContext(String configLocation) {
        this(configLocation, ClassUtils.getDefaultClassLoader());
    }

    public AbstractApplicationContext(String configLocation, ClassLoader classLoader) {
        defaultBeanFactory = new DefaultBeanFactory();
        xmlBeanDefinitionReader = new XMLBeanDefinitionReader(defaultBeanFactory);
        Resource resource = getResourceByPath(configLocation);
        xmlBeanDefinitionReader.loadBeanDefinition(resource);
        defaultBeanFactory.setBeanClassLoader(this.getBeanClassLoader());
    }

    @Override
    public Object getBean(String id) {
        return defaultBeanFactory.getBean(id);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public ClassLoader getBeanClassLoader() {
        return classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }
}
