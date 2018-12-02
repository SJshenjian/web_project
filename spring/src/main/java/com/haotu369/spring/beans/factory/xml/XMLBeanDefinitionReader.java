package com.haotu369.spring.beans.factory.xml;

import com.haotu369.spring.beans.BeansDefinition;
import com.haotu369.spring.beans.PropertyValue;
import com.haotu369.spring.beans.factory.BeanDefinitionStoreException;
import com.haotu369.spring.beans.factory.config.RuntimeBeanReference;
import com.haotu369.spring.beans.factory.config.TypedStringValue;
import com.haotu369.spring.beans.factory.support.BeanDefinitionRegistry;
import com.haotu369.spring.beans.factory.support.GenericBeanDefinition;
import com.haotu369.spring.core.io.Resource;
import com.haotu369.spring.util.ClassUtils;
import com.haotu369.spring.util.StringUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * SRP单一职责原则
 *
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/11
 */
public class XMLBeanDefinitionReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(XMLBeanDefinitionReader.class);

    private static final String ID_ATTRIBUTE = "id";
    private static final String CLASS_ATTRIBUTE = "class";
    private static final String SCOPE_ATTRIBUTE = "scope";

    private static final String PROPERTY_ATTRIBUTE = "property";
    private static final String NAME_ATTRIBUTE = "name";
    private static final String REF_ATTRIBUTE = "ref";
    private static final String VALUE_ATTRIBUTE = "value";

    private BeanDefinitionRegistry beanDefinitionRegistry;

    public XMLBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void loadBeanDefinition(Resource resource) {
        try(
                InputStream inputStream = resource.getInputStream();
        ) {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(inputStream);
            Element root = document.getRootElement();
            List<Element> elements = root.elements();
            for (int i = 0; i < elements.size(); i++) {
                Element element = elements.get(i);
                String beanId = element.attributeValue(ID_ATTRIBUTE);
                String className = element.attributeValue(CLASS_ATTRIBUTE);
                String scope = element.attributeValue(SCOPE_ATTRIBUTE);
                BeansDefinition beansDefinition = new GenericBeanDefinition(beanId, className);
                if (scope != null) {
                    beansDefinition.setScope(scope);
                }
                // 解析属性
                parsePropertyElement(element, beansDefinition);

                beanDefinitionRegistry.registryBeanDefinition(beanId, beansDefinition);
            }
        } catch (Exception e) {
            throw new BeanDefinitionStoreException("IOException parsing XML document from '" + resource.getDescription() + "' fail");
        }
    }

    public void parsePropertyElement(Element element, BeansDefinition beansDefinition) {
        Iterator iterator = element.elementIterator(PROPERTY_ATTRIBUTE);
        while (iterator.hasNext()) {
            Element propElement = (Element) iterator.next();
            String propertyName = propElement.attributeValue(NAME_ATTRIBUTE);
            if (!StringUtils.hasLength(propertyName)) {
                LOGGER.error("Tag 'property' must have a 'name' attribute");
                return ;
            }

            Object value = parsePropertyValue(propElement, beansDefinition, propertyName);
            PropertyValue propertyValue = new PropertyValue(propertyName, value);
            beansDefinition.getPropertyValues().add(propertyValue);
        }
    }

    public Object parsePropertyValue(Element element, BeansDefinition beansDefinition, String propertyName) {
        String elementName = (propertyName != null) ? "<property> element for property '" + propertyName + "'" : "<constructor-arg> element";
        boolean hasRefAttribute = element.attribute(REF_ATTRIBUTE) != null;
        boolean hasValueAttribute = element.attribute(VALUE_ATTRIBUTE) != null;

        if (hasRefAttribute) {
            String refName = element.attributeValue(REF_ATTRIBUTE);
            if (!StringUtils.hasText(refName)) {
                LOGGER.error(elementName + " contains empty 'ref' attribute");
            }
            RuntimeBeanReference ref = new RuntimeBeanReference(refName);
            return ref;
        }
        if (hasValueAttribute) {
            String value = element.attributeValue(VALUE_ATTRIBUTE);
            TypedStringValue typedStringValue = new TypedStringValue(value);
            return typedStringValue;
        }
        throw new RuntimeException(elementName + "must specify a ref or value");
    }
}
