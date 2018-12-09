package com.haotu369.spring.v1;

import com.haotu369.spring.core.io.ClassPathResource;
import com.haotu369.spring.core.io.FileSystemResource;
import com.haotu369.spring.core.io.Resource;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/16
 */
public class ResourceTestV1 {

    @Test
    public void testClassPathResource() {
        Resource resource = new ClassPathResource("petstore-v1.xml");
        try(
                InputStream inputStream = resource.getInputStream();
                ) {
            Assert.assertNotNull(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void testFileSystemResource() {
        Resource resource = new FileSystemResource("src\\" +
                "main\\resources\\petstore-v1.xml");
        try(
                InputStream inputStream = resource.getInputStream();
        ) {
            Assert.assertNotNull(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
