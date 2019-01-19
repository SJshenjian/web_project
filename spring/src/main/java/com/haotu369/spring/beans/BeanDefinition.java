package com.haotu369.spring.beans;

import java.util.List;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/28
 */
public interface BeanDefinition {

    static final String SCOPE_SINGLETON = "singleton";
    static final String SCOPE_PROTOTYPE = "prototype";
    static final String SCOPE_DEFAULT = "";

    boolean isSingleton();
    boolean isPrototype();

    String getScope();
    void setScope(String scope);

    String getId();
    void setBeanClassName(String beanClassName);
    String getBeanClassName();
    List<PropertyValue> getPropertyValues();
    ConstructorArgument getConstructorArgument();
    boolean hasConstructorArgumentValues();
}
