package com.haotu369.spring.context.annotation;

import com.haotu369.spring.beans.factory.support.AnnotatedBeanDefinition;
import com.haotu369.spring.beans.factory.support.BeanDefinitionRegistry;
import com.haotu369.spring.beans.factory.support.GenericBeanDefinition;
import com.haotu369.spring.core.type.AnnotationMetadata;
import com.haotu369.spring.core.type.classreading.MetadataReader;
import com.haotu369.spring.util.Assert;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/19
 */
public class ScannedGenericBeanDefinition extends GenericBeanDefinition implements AnnotatedBeanDefinition {

    private final AnnotationMetadata metadata;

    public ScannedGenericBeanDefinition(MetadataReader metadataReader) {
        Assert.notNull(metadataReader, "MetadataReader must not be null");
        this.metadata = metadataReader.getAnnotationMetadata();
        setBeanClassName(this.metadata.getClassName());
    }

    public final AnnotationMetadata getMetadata() {
        return this.metadata;
    }
}
