package com.haotu369.spring.beans.factory.xml;

import com.haotu369.spring.beans.BeansDefinition;
import com.haotu369.spring.beans.factory.BeanDefinitionStoreException;
import com.haotu369.spring.beans.factory.support.BeanDefinitionRegistry;
import com.haotu369.spring.beans.factory.support.GenericBeanDefinition;
import com.haotu369.spring.util.ClassUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/11
 */
public class XMLBeanDefinitionReader {

    private static final String ID_ATTRIBUTE = "id";
    private static final String CLASS_ATTRIBUTE = "class";
    private BeanDefinitionRegistry beanDefinitionRegistry;

    public XMLBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void loadBeanDefinition(String file) {
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
                beanDefinitionRegistry.registryBeanDefinition(beanId, beansDefinition);
            }
        } catch (Exception e) {
            throw new BeanDefinitionStoreException("parsing '" + file + "' fail");
        }
    }
}
