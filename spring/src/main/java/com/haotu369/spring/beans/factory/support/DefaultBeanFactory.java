package com.haotu369.spring.beans.factory.support;

import com.haotu369.spring.beans.BeansDefinition;
import com.haotu369.spring.beans.PropertyValue;
import com.haotu369.spring.beans.factory.BeanCreationException;
import com.haotu369.spring.beans.factory.config.ConfigurableBeanFactory;
import com.haotu369.spring.util.ClassUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
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
        // 实例化bean
        Object bean = instantiateBean(beansDefinition);
        // 设置属性
        populateBean(beansDefinition, bean);
        return bean;
    }

    private Object instantiateBean(BeansDefinition beansDefinition) {
        String className = beansDefinition.getBeanClassName();
        try {
            Class clazz = this.getBeanClassLoader().loadClass(className);
            return clazz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("Creating bean for '" + className + "' fail");
        }
    }

    private void populateBean(BeansDefinition beansDefinition, Object bean) {
        List<PropertyValue> propertyValues = beansDefinition.getPropertyValues();
        if (propertyValues == null || propertyValues.isEmpty()) {
            return ;
        }
        try {
            for (PropertyValue propertyValue : propertyValues) {
                String propName = propertyValue.getName();
                Object originValue = propertyValue.getValue();
                BeanDefinitionValueResolver resolver = new BeanDefinitionValueResolver(this);
                Object resolvedValue = resolver.resolveValueIfNecessary(originValue);

                // 通过JDK javabean相关方法实现注入
                BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
                PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor descriptor : descriptors) {
                    if (propName.equals(descriptor.getName())) {
                        descriptor.getWriteMethod().invoke(bean, resolvedValue);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new BeanCreationException("Failed to obtain BeanInfo from " + bean.getClass());
        }
    }
}
