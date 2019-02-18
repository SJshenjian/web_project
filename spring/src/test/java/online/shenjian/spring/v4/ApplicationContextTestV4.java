package online.shenjian.spring.v4;

import online.shenjian.service.v4.PetStoreService;
import online.shenjian.spring.context.ApplicationContext;
import online.shenjian.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/31
 */
public class ApplicationContextTestV4 {

    @Test
    public void testGetBeanProperty() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("petstore-v4.xml");

        PetStoreService petStoreService = (PetStoreService) applicationContext.getBean("petStore");
        Assert.assertNotNull(petStoreService);
    }
}
