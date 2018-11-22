package com.haotu369.spring.beans.factory.support;

import com.haotu369.spring.beans.BeansDefinition;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/28
 */
public class GenericBeanDefinition implements BeansDefinition {

    private String id;
    private String className;
    private boolean singleton = true;
    private boolean prototype = false;
    private String scope = SCOPE_DEFAULT;

    public GenericBeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    @Override
    public boolean isSingleton() {
        return singleton;
    }

    @Override
    public boolean isPrototype() {
        return prototype;
    }

    @Override
    public String getScope() {
        return scope;
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    @Override
    public String getBeanClassName() {
        return className;
    }
}
