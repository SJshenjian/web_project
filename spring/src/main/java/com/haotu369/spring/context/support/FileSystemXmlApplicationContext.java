package com.haotu369.spring.context.support;

import com.haotu369.spring.core.io.FileSystemResource;
import com.haotu369.spring.core.io.Resource;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/16
 */
public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

    public FileSystemXmlApplicationContext(String configLocation) {
        super(configLocation);
    }

    @Override
    public Resource getResourceByPath(String path) {
        return new FileSystemResource(path);
    }
}
