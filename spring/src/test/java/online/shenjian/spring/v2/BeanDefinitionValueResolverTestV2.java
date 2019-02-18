package online.shenjian.spring.v2;

import online.shenjian.dao.AccountDao;
import online.shenjian.spring.beans.factory.config.RuntimeBeanReference;
import online.shenjian.spring.beans.factory.config.TypedStringValue;
import online.shenjian.spring.beans.factory.support.BeanDefinitionValueResolver;
import online.shenjian.spring.beans.factory.support.DefaultBeanFactory;
import online.shenjian.spring.beans.factory.xml.XmlBeanDefinitionReader;
import online.shenjian.spring.core.io.ClassPathResource;
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
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v2.xml"));

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
