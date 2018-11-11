package com.haotu369.spring;

import com.haotu369.service.PetStoreService;
import com.haotu369.spring.beans.BeansDefinition;
import com.haotu369.spring.beans.factory.BeanFactory;
import com.haotu369.spring.beans.factory.BeanCreationException;
import com.haotu369.spring.beans.factory.BeanDefinitionStoreException;
import com.haotu369.spring.beans.factory.support.BeanDefinitionRegistry;
import com.haotu369.spring.beans.factory.support.DefaultBeanFactory;
import com.haotu369.spring.beans.factory.xml.XMLBeanDefinitionReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/28
 */
public class BeanFactoryTest {
    private DefaultBeanFactory factory;
    private XMLBeanDefinitionReader xmlBeanDefinitionReader;

    @Before
    public void setUp() {
        factory = new DefaultBeanFactory();
        xmlBeanDefinitionReader = new XMLBeanDefinitionReader(factory);
    }

    @Test
    public void testBeanFactory() {
        xmlBeanDefinitionReader.loadBeanDefinition("petstore-v1.xml");
        BeansDefinition definition = factory.getBeanDefinition("petStore");
        String className = definition.getBeanClassName();

        assertEquals("com.haotu369.service.PetStoreService", className);

        PetStoreService petStoreService = (PetStoreService) factory.getBean("petStore");
        assertNotNull(petStoreService);
    }

    @Test(expected = BeanCreationException.class)
    public void testInvalidBean(){
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XMLBeanDefinitionReader xmlBeanDefinitionReader = new XMLBeanDefinitionReader(factory);
        xmlBeanDefinitionReader.loadBeanDefinition("petstore-v1.xml");
        factory.getBean("invalid");
    }

    @Test(expected = BeanDefinitionStoreException.class)
    public void testInvalidXml() {
        xmlBeanDefinitionReader.loadBeanDefinition("invalid.xml");
    }
}
