package com.haotu369.spring.v1;

import com.haotu369.service.PetStoreService;
import com.haotu369.spring.beans.BeansDefinition;
import com.haotu369.spring.beans.factory.BeanCreationException;
import com.haotu369.spring.beans.factory.BeanDefinitionStoreException;
import com.haotu369.spring.beans.factory.support.DefaultBeanFactory;
import com.haotu369.spring.beans.factory.xml.XMLBeanDefinitionReader;
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
    private XMLBeanDefinitionReader xmlBeanDefinitionReader;

    @Before
    public void setUp() {
        factory = new DefaultBeanFactory();
        xmlBeanDefinitionReader = new XMLBeanDefinitionReader(factory);
    }

    @Test
    public void testBeanFactory() {
        Resource resource = new ClassPathResource("petstore-v1.xml");
        xmlBeanDefinitionReader.loadBeanDefinition(resource);
        BeansDefinition definition = factory.getBeanDefinition("petStore");
        String className = definition.getBeanClassName();

        assertTrue(definition.isSingleton());
        assertFalse(definition.isPrototype());
        assertEquals(BeansDefinition.SCOPE_DEFAULT, definition.getScope());

        assertEquals("com.haotu369.service.PetStoreService", className);

        PetStoreService petStoreService = (PetStoreService) factory.getBean("petStore");
        assertNotNull(petStoreService);

        PetStoreService petStoreServiceTwo = (PetStoreService) factory.getBean("petStore");
        assertTrue(petStoreService.equals(petStoreServiceTwo));

    }

    @Test(expected = BeanCreationException.class)
    public void testInvalidBean(){
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XMLBeanDefinitionReader xmlBeanDefinitionReader = new XMLBeanDefinitionReader(factory);
        Resource resource = new ClassPathResource("petstore-v1.xml");
        xmlBeanDefinitionReader.loadBeanDefinition(resource);
        factory.getBean("invalid");
    }

    @Test(expected = BeanDefinitionStoreException.class)
    public void testInvalidXml() {
        Resource resource = new ClassPathResource("invalid.xml");
        xmlBeanDefinitionReader.loadBeanDefinition(resource);
    }
}
