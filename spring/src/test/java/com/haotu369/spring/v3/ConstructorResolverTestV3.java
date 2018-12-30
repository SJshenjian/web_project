package com.haotu369.spring.v3;

import com.haotu369.dao.AccountDao;
import com.haotu369.service.v3.PetStoreService;
import com.haotu369.spring.beans.BeansDefinition;
import com.haotu369.spring.beans.factory.support.ConstructorResolver;
import com.haotu369.spring.beans.factory.support.DefaultBeanFactory;
import com.haotu369.spring.beans.factory.xml.XMLBeanDefinitionReader;
import com.haotu369.spring.core.io.ClassPathResource;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/10
 */
public class ConstructorResolverTestV3 {

    @Test
    public void testAutowireConstructor() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XMLBeanDefinitionReader reader = new XMLBeanDefinitionReader(factory);
        reader.loadBeanDefinition(new ClassPathResource("petstore-v3.xml"));

        BeansDefinition definition = factory.getBeanDefinition("petStoreServiceOne");

        ConstructorResolver resolver = new ConstructorResolver(factory);
        PetStoreService petStoreServiceOne = (PetStoreService) resolver.autowireConstructor(definition);

        assertTrue(petStoreServiceOne.getAccountDao() instanceof AccountDao);
        assertEquals(2, petStoreServiceOne.getVersion());
        assertEquals(null, petStoreServiceOne.getAuthor());
    }
}
