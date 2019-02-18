package online.shenjian.spring.context.support;

import online.shenjian.spring.beans.factory.support.DefaultBeanFactory;
import online.shenjian.spring.beans.factory.xml.XmlBeanDefinitionReader;
import online.shenjian.spring.context.ApplicationContext;
import online.shenjian.spring.core.io.Resource;
import online.shenjian.spring.util.ClassUtils;

/**
 * 设计模式：模板方法
 * 设计原则：开放关闭原则（对修改关闭，对扩展开放）
 *
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/16
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    private DefaultBeanFactory defaultBeanFactory;
    private XmlBeanDefinitionReader xmlBeanDefinitionReader;
    private ClassLoader classLoader;

    public abstract Resource getResourceByPath(String path);

    public AbstractApplicationContext(String configLocation) {
        this(configLocation, ClassUtils.getDefaultClassLoader());
    }

    public AbstractApplicationContext(String configLocation, ClassLoader classLoader) {
        defaultBeanFactory = new DefaultBeanFactory();
        xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultBeanFactory);
        Resource resource = getResourceByPath(configLocation);
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);
        defaultBeanFactory.setBeanClassLoader(this.getBeanClassLoader());
    }

    @Override
    public Object getBean(String id) {
        return defaultBeanFactory.getBean(id);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public ClassLoader getBeanClassLoader() {
        return classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }
}
