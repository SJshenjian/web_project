package online.shenjian.spring.beans.factory.support;

import online.shenjian.spring.beans.BeanDefinition;

/**
 * 接口隔离原则，分担BeanFactory职责
 *
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/11
 */
public interface BeanDefinitionRegistry {

    BeanDefinition getBeanDefinition(String id);

    void registryBeanDefinition(String id, BeanDefinition beanDefinition);
}