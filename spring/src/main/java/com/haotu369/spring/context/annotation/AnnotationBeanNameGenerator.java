package com.haotu369.spring.context.annotation;

import com.haotu369.spring.beans.BeanDefinition;
import com.haotu369.spring.beans.factory.support.AnnotatedBeanDefinition;
import com.haotu369.spring.beans.factory.support.BeanDefinitionRegistry;
import com.haotu369.spring.beans.factory.support.BeanNameGenerator;
import com.haotu369.spring.core.annotation.AnnotationAttributes;
import com.haotu369.spring.core.type.AnnotationMetadata;
import com.haotu369.spring.util.ClassUtils;
import com.haotu369.spring.util.StringUtils;

import java.beans.Introspector;
import java.util.Set;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/19
 */
public class AnnotationBeanNameGenerator implements BeanNameGenerator {

    @Override
    public String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry registry) {
        if (beanDefinition instanceof AnnotatedBeanDefinition) {
            String beanName = determineBeanNameFromAnnotation((AnnotatedBeanDefinition)beanDefinition);
            if (StringUtils.hasText(beanName)) {
                return beanName;
            }
        }
        return buildDefaultBeanName(beanDefinition, registry);
    }

    protected String determineBeanNameFromAnnotation(AnnotatedBeanDefinition annotatedDef) {
        AnnotationMetadata amd = annotatedDef.getMetadata();
        Set<String> types = amd.getAnnotationTypes();
        String beanName = null;
        for (String type : types) {
            AnnotationAttributes attributes = amd.getAnnotationAttributes(type);
            if (attributes.get("value") != null) {
                Object value = attributes.get("value");
                if (value instanceof String) {
                    String strVal = (String) value;
                    if (StringUtils.hasLength(strVal)) {
                        if (beanName != null && !strVal.equals(beanName)) {
                            throw new IllegalStateException("Stereotype annotations suggest inconsistent " +
                                    "component names: '" + beanName + "' versus '" + strVal + "'");
                        }
                        beanName = strVal;
                    }
                }
            }
        }
        return beanName;
    }

    protected String buildDefaultBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry registry) {
        return buildDefaultBeanName(beanDefinition);
    }

    protected String buildDefaultBeanName(BeanDefinition beanDefinition) {
        String shortClassName = ClassUtils.getShortName(beanDefinition.getBeanClassName());
        return Introspector.decapitalize(shortClassName);
    }
}
