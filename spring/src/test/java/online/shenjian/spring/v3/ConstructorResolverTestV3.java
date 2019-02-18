package online.shenjian.spring.v3;

import online.shenjian.dao.AccountDao;
import online.shenjian.service.v3.PetStoreService;
import online.shenjian.spring.beans.BeanDefinition;
import online.shenjian.spring.beans.factory.support.ConstructorResolver;
import online.shenjian.spring.beans.factory.support.DefaultBeanFactory;
import online.shenjian.spring.beans.factory.xml.XmlBeanDefinitionReader;
import online.shenjian.spring.core.io.ClassPathResource;
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
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v3.xml"));

        BeanDefinition definition = factory.getBeanDefinition("petStoreServiceOne");

        ConstructorResolver resolver = new ConstructorResolver(factory);
        PetStoreService petStoreServiceOne = (PetStoreService) resolver.autowireConstructor(definition);

        assertTrue(petStoreServiceOne.getAccountDao() instanceof AccountDao);
        assertEquals(2, petStoreServiceOne.getVersion());
        assertEquals(null, petStoreServiceOne.getAuthor());
    }
}
