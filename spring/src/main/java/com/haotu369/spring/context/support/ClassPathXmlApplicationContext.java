package com.haotu369.spring.context.support;

import com.haotu369.spring.core.io.ClassPathResource;
import com.haotu369.spring.core.io.Resource;


/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/11
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configLocation) {
        super(configLocation);
    }

    @Override
    public Resource getResourceByPath(String path) {
        return new ClassPathResource(path, super.getBeanClassLoader());
    }
}
