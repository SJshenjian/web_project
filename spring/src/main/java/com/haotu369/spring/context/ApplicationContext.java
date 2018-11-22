package com.haotu369.spring.context;

import com.haotu369.spring.beans.factory.BeanFactory;
import com.haotu369.spring.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/11
 */
public interface ApplicationContext extends ConfigurableBeanFactory {

    @Override
    Object getBean(String id);
}
