package com.haotu369.spring.beans.factory.support;

import com.haotu369.spring.beans.BeanDefinition;
import com.haotu369.spring.beans.PropertyValue;
import com.haotu369.spring.beans.SimpleTypeConverter;
import com.haotu369.spring.beans.TypeConverter;
import com.haotu369.spring.beans.factory.BeanCreationException;
import com.haotu369.spring.beans.factory.config.ConfigurableBeanFactory;
import com.haotu369.spring.util.ClassUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
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
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public DefaultBeanFactory() {
    }

    @Override
    public BeanDefinition getBeanDefinition(String id) {
        return beanDefinitionMap.get(id);
    }

    @Override
    public void registryBeanDefinition(String id, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(id, beanDefinition);
    }

    @Override
    public Object getBean(String id) {
        BeanDefinition beanDefinition = this.getBeanDefinition(id);
        if (beanDefinition == null) {
            throw new BeanCreationException("Bean definition does not exist");
        }
        if (beanDefinition.isSingleton()) {
            Object bean = super.getSingleton(id);
            if (bean == null) {
                bean = createBean(beanDefinition);
                super.registrySingleton(id, bean);
            }
            return bean;
        }

        return createBean(beanDefinition);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public ClassLoader getBeanClassLoader() {
        return classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    private Object createBean(BeanDefinition beanDefinition) {
        // 实例化bean
        Object bean = instantiateBean(beanDefinition);
        // 设置属性
        populateBean(beanDefinition, bean);
        return bean;
    }

    private Object instantiateBean(BeanDefinition beanDefinition) {
        if (beanDefinition.hasConstructorArgumentValues()) {
            ConstructorResolver constructorResolver = new ConstructorResolver(this);
            return constructorResolver.autowireConstructor(beanDefinition);
        }

        String className = beanDefinition.getBeanClassName();
        try {
            Class clazz = this.getBeanClassLoader().loadClass(className);
            return clazz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("Creating bean for '" + className + "' fail");
        }
    }

    private void populateBean(BeanDefinition beanDefinition, Object bean) {
        List<PropertyValue> propertyValues = beanDefinition.getPropertyValues();
        if (propertyValues == null || propertyValues.isEmpty()) {
            return ;
        }
        BeanDefinitionValueResolver resolver = new BeanDefinitionValueResolver(this);
        TypeConverter converter = new SimpleTypeConverter();
        try {
            for (PropertyValue propertyValue : propertyValues) {
                String propName = propertyValue.getName();
                Object originValue = propertyValue.getValue();
                Object resolvedValue = resolver.resolveValueIfNecessary(originValue);

                // 通过JDK javabean相关方法实现注入
                BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
                PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor descriptor : descriptors) {
                    if (propName.equals(descriptor.getName())) {
                        Object convertedValue = converter.convertIfNecessary(resolvedValue, descriptor.getPropertyType());
                        descriptor.getWriteMethod().invoke(bean, convertedValue);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new BeanCreationException("Failed to obtain BeanInfo from " + bean.getClass());
        }
    }
}
