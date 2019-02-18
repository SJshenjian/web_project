package online.shenjian.spring.beans.factory.xml;

import online.shenjian.spring.beans.BeanDefinition;
import online.shenjian.spring.beans.ConstructorArgument;
import online.shenjian.spring.beans.PropertyValue;
import online.shenjian.spring.beans.factory.BeanDefinitionStoreException;
import online.shenjian.spring.beans.factory.config.RuntimeBeanReference;
import online.shenjian.spring.beans.factory.config.TypedStringValue;
import online.shenjian.spring.beans.factory.support.BeanDefinitionRegistry;
import online.shenjian.spring.beans.factory.support.GenericBeanDefinition;
import online.shenjian.spring.context.annotation.ClassPathBeanDefinitionScanner;
import online.shenjian.spring.core.io.Resource;
import online.shenjian.spring.util.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * SRP单一职责原则
 *
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/11
 */
public class XmlBeanDefinitionReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlBeanDefinitionReader.class);

    public static final String ID_ATTRIBUTE = "id";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String SCOPE_ATTRIBUTE = "scope";

    public static final String PROPERTY_ELEMENT = "property";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String REF_ATTRIBUTE = "ref";
    public static final String VALUE_ATTRIBUTE = "value";

    public static final String CONSTRUCTOR_ARG_ELEMENT = "constructor-arg";
    public static final String TYPE_ATTRIBUTE = "type";

    public static final String BEANS_NAMESPACE_URI = "http://www.springframework.org/schema/beans";
    public static final String CONTEXT_NAMESPACE_URI = "http://www.springframework.org/schema/context";
    private static final String BASE_PACKAGE_ATTRIBUTE = "base-package";

    private BeanDefinitionRegistry beanDefinitionRegistry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void loadBeanDefinitions(Resource resource) {
        try(
                InputStream inputStream = resource.getInputStream();
        ) {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(inputStream);
            Element root = document.getRootElement();
            List<Element> elements = root.elements();
            for (int i = 0; i < elements.size(); i++) {
                Element element = elements.get(i);
                String namespaceUri = element.getNamespaceURI();
                if (this.isDefaultNameSpace(namespaceUri)) {
                    parseDefaultElement(element);
                } else if (this.isContextNameSpace(namespaceUri)) {
                    parseComponentElement(element);
                }
            }
        } catch (Exception e) {
            throw new BeanDefinitionStoreException("IOException parsing XML document from '" + resource.getDescription() + "' fail");
        }
    }

    private void parseComponentElement(Element element) {
        String basePackages = element.attributeValue(BASE_PACKAGE_ATTRIBUTE);
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanDefinitionRegistry);
        scanner.doScan(basePackages);
    }

    private void parseDefaultElement(Element element) {
        String beanId = element.attributeValue(ID_ATTRIBUTE);
        String className = element.attributeValue(CLASS_ATTRIBUTE);
        String scope = element.attributeValue(SCOPE_ATTRIBUTE);
        BeanDefinition beanDefinition = new GenericBeanDefinition(beanId, className);
        if (scope != null) {
            beanDefinition.setScope(scope);
        }
        // 解析属性
        parsePropertyElement(element, beanDefinition);
        parseConstructorArgElement(element, beanDefinition);
        beanDefinitionRegistry.registryBeanDefinition(beanId, beanDefinition);
    }

    public boolean isDefaultNameSpace(String namespaceUri) {
        return (!StringUtils.hasLength(namespaceUri) || BEANS_NAMESPACE_URI.equals(namespaceUri));
    }

    private boolean isContextNameSpace(String namespaceUri) {
        return (!StringUtils.hasLength(namespaceUri) || CONTEXT_NAMESPACE_URI.equals(namespaceUri));
    }

    public void parsePropertyElement(Element element, BeanDefinition beanDefinition) {
        Iterator iterator = element.elementIterator(PROPERTY_ELEMENT);
        while (iterator.hasNext()) {
            Element propElement = (Element) iterator.next();
            String propertyName = propElement.attributeValue(NAME_ATTRIBUTE);
            if (!StringUtils.hasLength(propertyName)) {
                LOGGER.error("Tag 'property' must have a 'name' attribute");
                return ;
            }

            Object value = parsePropertyValue(propElement, beanDefinition, propertyName);
            PropertyValue propertyValue = new PropertyValue(propertyName, value);
            beanDefinition.getPropertyValues().add(propertyValue);
        }
    }

    public void parseConstructorArgElement(Element element, BeanDefinition beanDefinition) {
        Iterator iterator = element.elementIterator(CONSTRUCTOR_ARG_ELEMENT);
        while (iterator.hasNext()) {
            Element constructorArgElement = (Element) iterator.next();
            String typeAttr = constructorArgElement.attributeValue(TYPE_ATTRIBUTE);
            String nameAttr = constructorArgElement.attributeValue(NAME_ATTRIBUTE);
            Object value = parsePropertyValue(constructorArgElement, beanDefinition, null);
            ConstructorArgument.ValueHolder valueHolder = new ConstructorArgument.ValueHolder(value);
            if (typeAttr != null) {
                valueHolder.setType(typeAttr);
            }
            if (nameAttr != null) {
                valueHolder.setName(nameAttr);
            }
            beanDefinition.getConstructorArgument().addArgumentValue(valueHolder);
        }
    }

    public Object parsePropertyValue(Element element, BeanDefinition beanDefinition, String propertyName) {
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
