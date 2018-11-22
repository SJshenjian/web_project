package com.haotu369.spring.beans.factory.support;

import com.haotu369.spring.beans.BeansDefinition;
import com.haotu369.spring.beans.factory.BeanCreationException;
import com.haotu369.spring.beans.factory.config.ConfigurableBeanFactory;
import com.haotu369.spring.util.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/28
 */
public class DefaultBeanFactory extends  DefaultSingletonBeanRegistry implements ConfigurableBeanFactory, BeanDefinitionRegistry {

    private ClassLoader classLoader;
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
        if (beansDefinition.isSingleton()) {
            Object bean = super.getSingleton(id);
            if (bean == null) {
                bean = createBean(beansDefinition);
                super.registrySingleton(id, bean);
            }
            return bean;
        }

        return createBean(beansDefinition);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public ClassLoader getBeanClassLoader() {
        return classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    private Object createBean(BeansDefinition beansDefinition) {
        String className = beansDefinition.getBeanClassName();
        try {
            Class clazz = this.getBeanClassLoader().loadClass(className);
            return clazz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("Creating bean for '" + className + "' fail");
        }
    }
}
