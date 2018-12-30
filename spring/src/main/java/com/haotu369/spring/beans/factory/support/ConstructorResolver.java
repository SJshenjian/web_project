package com.haotu369.spring.beans.factory.support;

import com.haotu369.spring.beans.*;
import com.haotu369.spring.beans.factory.BeanCreationException;
import com.haotu369.spring.beans.factory.config.ConfigurableBeanFactory;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * 构造器注入核心实现类
 *
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/10
 */
public class ConstructorResolver {

    private ConfigurableBeanFactory beanFactory;

    public ConstructorResolver (ConfigurableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object autowireConstructor(final BeansDefinition definition) {
        Class<?> beanClass;
        Constructor<?> constructorToUse = null;

        try {
            beanClass = this.beanFactory.getBeanClassLoader().loadClass(definition.getBeanClassName());
        } catch (ClassNotFoundException e) {
            throw new BeanCreationException(definition.getId(), "Instantiation of bean failed, can't resolve class", e);
        }

        Constructor<?>[] candidateConstructors = beanClass.getConstructors();
        ConstructorArgument constructorArgument = definition.getConstructorArgument();
        Object[] argsToUse = new Object[constructorArgument.getArgumentCount()];

        BeanDefinitionValueResolver valueResolver = new BeanDefinitionValueResolver(beanFactory);
        TypeConverter typeConverter = new SimpleTypeConverter();

        for (int i = 0; i < candidateConstructors.length; i++) {
            Class<?>[] parameterTypes = candidateConstructors[i].getParameterTypes();
            if (parameterTypes.length != constructorArgument.getArgumentCount()) {
                continue ;
            }

            boolean result = this.valuesMatchTypes(parameterTypes, constructorArgument.getArgumentValues(),
                    argsToUse, valueResolver, typeConverter);

            if (result) {
                constructorToUse = candidateConstructors[i];
                break;
            }
        }

        if (constructorToUse == null) {
            throw new BeanCreationException( definition.getId(), "can't find a apporiate constructor");
        }

        try {
            return constructorToUse.newInstance(argsToUse);
        } catch (Exception e) {
            throw new BeanCreationException( definition.getId(), "can't find a create instance using " + constructorToUse);
        }
    }

    private boolean valuesMatchTypes(Class<?>[] parameterTypes, List<ConstructorArgument.ValueHolder> argumentValues, Object[] argsToUse, BeanDefinitionValueResolver valueResolver, TypeConverter typeConverter) {
        for (int i = 0; i < parameterTypes.length; i++) {
            Object originalValue = argumentValues.get(i).getValue();
            Object resolvedValue =  valueResolver.resolveValueIfNecessary(originalValue);

            try {
                Object convertedValue = typeConverter.convertIfNecessary(resolvedValue, parameterTypes[i]);
                argsToUse[i] = convertedValue;
            } catch (TypeMismatchException e) {
                return false;
            }
        }
        return true;
    }
}
