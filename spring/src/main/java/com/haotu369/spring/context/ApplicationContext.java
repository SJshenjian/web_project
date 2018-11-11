package com.haotu369.spring.context;

import com.haotu369.spring.beans.factory.BeanFactory;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/11
 */
public interface ApplicationContext extends BeanFactory {

    @Override
    Object getBean(String id);
}
