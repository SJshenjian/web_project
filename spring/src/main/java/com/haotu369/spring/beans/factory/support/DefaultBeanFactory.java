package com.haotu369.spring.beans.factory.support;

import com.haotu369.spring.beans.BeansDefinition;
import com.haotu369.spring.beans.factory.BeanCreationException;
import com.haotu369.spring.beans.factory.BeanDefinitionStoreException;
import com.haotu369.spring.beans.factory.BeanFactory;
import com.haotu369.spring.util.ClassUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/28
 */
public class DefaultBeanFactory implements BeanFactory, BeanDefinitionRegistry {

    private Map<String, BeansDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public DefaultBeanFactory() {
    }

    @Override
    public BeansDefinition getBeanDefinition(String id) {
        return beanDefinitionMap.get(id);
    }

    @Override
    public void registryBeanDefinition(String id, BeansDefinition beansDefinition) {
        this.beanDefinitionMap.put(id, beansDefinition);
    }

    @Override
    public Object getBean(String id) {
        BeansDefinition beansDefinition = this.getBeanDefinition(id);

        if (beansDefinition == null) {
            throw new BeanCreationException("Bean definition does not exist");
        }

        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        String className = null;
        try {
            className = beansDefinition.getBeanClassName();
            Class clazz = classLoader.loadClass(className);
            return clazz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("Creating bean for '" + className + "' fail");
        }
    }
}
