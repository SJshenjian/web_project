package com.haotu369.spring.beans.factory.support;

import com.haotu369.service.PetStoreService;
import com.haotu369.spring.beans.BeansDefinition;
import com.haotu369.spring.beans.factory.BeanFactory;
import com.haotu369.spring.util.ClassUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/28
 */
public class DefaultBeanFactory implements BeanFactory {

    private static final String ID_ATTRIBUTE = "id";
    private static final String CLASS_ATTRIBUTE = "class";

    private Map<String, BeansDefinition> beanDefinitionMap = new HashMap();

    public DefaultBeanFactory(String file) {
        this.loadBeanDefinition(file);
    }

    @Override
    public BeansDefinition getBeanDefinition(String id) {
        return beanDefinitionMap.get(id);
    }

    @Override
    public Object getBean(String id) {
        BeansDefinition beansDefinition = this.getBeanDefinition(id);

        if (beansDefinition == null) {
            throw new BeanCreationException("Bean definition does not exist");
        }

        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        String className = null;
        try {
            className = beansDefinition.getBeanClassName();
            Class clazz = classLoader.loadClass(className);
            return clazz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("Creating bean for '" + className + "' fail");
        }
    }

    private void loadBeanDefinition(String file) {
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();

        try(
            InputStream inputStream = classLoader.getResourceAsStream(file);
        ) {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(inputStream);
            Element root = document.getRootElement();
            List<Element> elements = root.elements();
            for (int i = 0; i < elements.size(); i++) {
                Element element = elements.get(i);
                String beanId = element.attributeValue(ID_ATTRIBUTE);
                String className = element.attributeValue(CLASS_ATTRIBUTE);
                BeansDefinition beansDefinition = new GenericBeanDefinition(beanId, className);
                beanDefinitionMap.put(beanId, beansDefinition);
            }
        } catch (Exception e) {
           throw new BeanDefinitionStoreException("parsing '" + file + "' fail");
        }
    }
}
