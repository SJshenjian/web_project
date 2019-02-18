package online.shenjian.spring.beans.factory.support;

import online.shenjian.spring.beans.factory.BeanFactory;
import online.shenjian.spring.beans.factory.config.RuntimeBeanReference;
import online.shenjian.spring.beans.factory.config.TypedStringValue;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/2
 */
public class BeanDefinitionValueResolver {

    private BeanFactory factory;

    public BeanDefinitionValueResolver(BeanFactory factory) {
        this.factory = factory;
    }

    public Object resolveValueIfNecessary(Object value) {
        if (value instanceof RuntimeBeanReference) {
            RuntimeBeanReference reference = (RuntimeBeanReference) value;
            String beanName = reference.getBeanName();
            return factory.getBean(beanName);
        }

        if (value instanceof TypedStringValue) {
            TypedStringValue stringValue = (TypedStringValue) value;
            return stringValue.getValue();
        }
        throw new RuntimeException("The value " + value + " has not implemented");
    }
}
