package com.haotu369.spring.v4;

import com.haotu369.spring.core.io.Resource;
import com.haotu369.spring.core.io.support.PackageResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/31
 */
public class PackageResourceLoaderTestV4 {

    @Test
    public void testPackageResourceLoader() throws IOException {
        PackageResourceLoader loader = new PackageResourceLoader();
        Resource[] resources = loader.getResources("com.haotu369.dao");

        Assert.assertEquals(2, resources.length);
    }
}
