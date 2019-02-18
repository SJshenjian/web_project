package online.shenjian.spring.context.support;

import online.shenjian.spring.core.io.ClassPathResource;
import online.shenjian.spring.core.io.Resource;


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
