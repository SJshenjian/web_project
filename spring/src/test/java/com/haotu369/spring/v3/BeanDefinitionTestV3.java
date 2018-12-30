package com.haotu369.spring.v3;

import com.haotu369.spring.beans.BeansDefinition;
import com.haotu369.spring.beans.ConstructorArgument;
import com.haotu369.spring.beans.factory.config.RuntimeBeanReference;
import com.haotu369.spring.beans.factory.config.TypedStringValue;
import com.haotu369.spring.beans.factory.support.DefaultBeanFactory;
import com.haotu369.spring.beans.factory.xml.XMLBeanDefinitionReader;
import com.haotu369.spring.core.io.ClassPathResource;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/9
 */
public class BeanDefinitionTestV3 {

    @Test
    public void testGetBeanDefinition() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XMLBeanDefinitionReader reader = new XMLBeanDefinitionReader(factory);
        reader.loadBeanDefinition(new ClassPathResource("petstore-v3.xml"));

        BeansDefinition beansDefinition = factory.getBeanDefinition("petStoreServiceOne");
        ConstructorArgument constructorArgument = beansDefinition.getConstructorArgument();
        List<ConstructorArgument.ValueHolder> valueHolders = constructorArgument.getArgumentValues();

        assertEquals(3, valueHolders.size());
        {
            RuntimeBeanReference reference = (RuntimeBeanReference)valueHolders.get(0).getValue();
            assertEquals("accountDao", reference.getBeanName());
        }
        {
            RuntimeBeanReference reference = (RuntimeBeanReference)valueHolders.get(1).getValue();
            assertEquals("itemDao", reference.getBeanName());
        }
        {
            TypedStringValue stringValue = (TypedStringValue)valueHolders.get(2).getValue();
            assertEquals("2", stringValue.getValue());
        }
    }
}
