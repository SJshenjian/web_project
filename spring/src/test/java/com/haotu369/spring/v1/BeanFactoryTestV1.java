package com.haotu369.spring.v1;

import com.haotu369.service.v1.PetStoreService;
import com.haotu369.spring.beans.BeanDefinition;
import com.haotu369.spring.beans.factory.BeanCreationException;
import com.haotu369.spring.beans.factory.BeanDefinitionStoreException;
import com.haotu369.spring.beans.factory.support.DefaultBeanFactory;
import com.haotu369.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.haotu369.spring.core.io.ClassPathResource;
import com.haotu369.spring.core.io.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/28
 */
public class BeanFactoryTestV1 {
    private DefaultBeanFactory factory;
    private XmlBeanDefinitionReader xmlBeanDefinitionReader;

    @Before
    public void setUp() {
        factory = new DefaultBeanFactory();
        xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
    }

    @Test
    public void testBeanFactory() {
        Resource resource = new ClassPathResource("petstore-v1.xml");
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);
        BeanDefinition definition = factory.getBeanDefinition("petStore");
        String className = definition.getBeanClassName();

        assertTrue(definition.isSingleton());
        assertFalse(definition.isPrototype());
        assertEquals(BeanDefinition.SCOPE_DEFAULT, definition.getScope());

        assertEquals("com.haotu369.service.v1.PetStoreService", className);

        PetStoreService petStoreService = (PetStoreService) factory.getBean("petStore");
        assertNotNull(petStoreService);

        PetStoreService petStoreServiceTwo = (PetStoreService) factory.getBean("petStore");
        assertTrue(petStoreService.equals(petStoreServiceTwo));

    }

    @Test(expected = BeanCreationException.class)
    public void testInvalidBean(){
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        Resource resource = new ClassPathResource("petstore-v1.xml");
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);
        factory.getBean("invalid");
    }

    @Test(expected = BeanDefinitionStoreException.class)
    public void testInvalidXml() {
        Resource resource = new ClassPathResource("invalid.xml");
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);
    }
}
