package online.shenjian.spring.context.annotation;

import online.shenjian.spring.beans.factory.support.AnnotatedBeanDefinition;
import online.shenjian.spring.beans.factory.support.GenericBeanDefinition;
import online.shenjian.spring.core.type.AnnotationMetadata;
import online.shenjian.spring.core.type.classreading.MetadataReader;
import online.shenjian.spring.util.Assert;

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
