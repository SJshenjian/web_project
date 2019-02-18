package online.shenjian.spring.v1;

import online.shenjian.service.v1.PetStoreService;
import online.shenjian.spring.context.ApplicationContext;
import online.shenjian.spring.context.support.ClassPathXmlApplicationContext;
import online.shenjian.spring.context.support.FileSystemXmlApplicationContext;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/11
 */
public class ApplicationContextTestV1 {

    @Test
    public void testClassPathXmlApplicationContext() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("petstore-v1.xml");
        PetStoreService petStoreService = (PetStoreService) applicationContext.getBean("petStore");
        assertNotNull(petStoreService);
    }

    @Test
    public void testFileSystemXmlApplicationContext() {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src\\" +
        "test\\resources\\petstore-v1.xml");
        PetStoreService petStoreService = (PetStoreService) applicationContext.getBean("petStore");
        assertNotNull(petStoreService);
    }
}
