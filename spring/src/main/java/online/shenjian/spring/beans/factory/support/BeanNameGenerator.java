package online.shenjian.spring.beans.factory.support;

import online.shenjian.spring.beans.BeanDefinition;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/19
 */
public interface BeanNameGenerator {

    String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry);
}
