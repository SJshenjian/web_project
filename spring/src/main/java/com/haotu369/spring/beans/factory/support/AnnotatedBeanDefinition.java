package com.haotu369.spring.beans.factory.support;

import com.haotu369.spring.beans.BeanDefinition;
import com.haotu369.spring.core.type.AnnotationMetadata;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/19
 */
public interface AnnotatedBeanDefinition extends BeanDefinition {

    AnnotationMetadata getMetadata();
}
