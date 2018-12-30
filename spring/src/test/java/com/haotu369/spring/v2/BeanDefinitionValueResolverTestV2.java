package com.haotu369.spring.v2;

import com.haotu369.dao.AccountDao;
import com.haotu369.spring.beans.factory.config.RuntimeBeanReference;
import com.haotu369.spring.beans.factory.config.TypedStringValue;
import com.haotu369.spring.beans.factory.support.BeanDefinitionValueResolver;
import com.haotu369.spring.beans.factory.support.DefaultBeanFactory;
import com.haotu369.spring.beans.factory.xml.XMLBeanDefinitionReader;
import com.haotu369.spring.core.io.ClassPathResource;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/2
 */
public class BeanDefinitionValueResolverTestV2 {

    @Test
    public void testResolveRuntimeBeanReference() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XMLBeanDefinitionReader reader = new XMLBeanDefinitionReader(factory);
        reader.loadBeanDefinition(new ClassPathResource("petstore-v2.xml"));

        BeanDefinitionValueResolver resolver = new BeanDefinitionValueResolver(factory);
        RuntimeBeanReference reference = new RuntimeBeanReference("accountDao");
        Object resolvedBeanValue = resolver.resolveValueIfNecessary(reference);

        assertNotNull(resolvedBeanValue);
        assertTrue(resolvedBeanValue instanceof AccountDao);

        TypedStringValue stringValue = new TypedStringValue("author");
        Object resolvedStringValue = resolver.resolveValueIfNecessary(stringValue);
        assertNotNull(stringValue);
        assertTrue(resolvedStringValue instanceof String);
    }
}
