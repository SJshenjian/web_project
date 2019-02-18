package online.shenjian.spring.beans.factory.support;

import online.shenjian.spring.beans.BeanDefinition;
import online.shenjian.spring.core.type.AnnotationMetadata;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/19
 */
public interface AnnotatedBeanDefinition extends BeanDefinition {

    AnnotationMetadata getMetadata();
}
