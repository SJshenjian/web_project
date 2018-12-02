package com.haotu369.spring.v2;

import com.haotu369.spring.beans.BeansDefinition;
import com.haotu369.spring.beans.PropertyValue;
import com.haotu369.spring.beans.factory.config.RuntimeBeanReference;
import com.haotu369.spring.beans.factory.support.DefaultBeanFactory;
import com.haotu369.spring.beans.factory.xml.XMLBeanDefinitionReader;
import com.haotu369.spring.core.io.ClassPathResource;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/2
 */
public class BeanDefinitionTestV2 {

    @Test
    public void testGetBeanDefinition() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XMLBeanDefinitionReader reader = new XMLBeanDefinitionReader(factory);
        reader.loadBeanDefinition(new ClassPathResource("petstore-v2.xml"));

        BeansDefinition beansDefinition = factory.getBeanDefinition("petStoreService");
        List<PropertyValue> propertyValues = beansDefinition.getPropertyValues();

        assertTrue(propertyValues.size() == 3);
        {
            PropertyValue propertyValue = this.getPropertyValue("accountDao", propertyValues);
            assertNotNull(propertyValue);
            assertTrue(propertyValue.getValue() instanceof RuntimeBeanReference);
        }
        {
            PropertyValue propertyValue = this.getPropertyValue("itemDao", propertyValues);
            assertNotNull(propertyValue);
            assertTrue(propertyValue.getValue() instanceof RuntimeBeanReference);
        }
    }

    private PropertyValue getPropertyValue(String name, List<PropertyValue> propertyValues) {
        for (PropertyValue propertyValue : propertyValues) {
            if (name.equals(propertyValue.getName())) {
                return propertyValue;
            }
        }
        return null;
    }
}
