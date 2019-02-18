package online.shenjian.spring.context;

import online.shenjian.spring.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/11
 */
public interface ApplicationContext extends ConfigurableBeanFactory {

    @Override
    Object getBean(String id);
}
