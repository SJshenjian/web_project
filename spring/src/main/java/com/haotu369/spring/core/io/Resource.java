package com.haotu369.spring.core.io;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/16
 */
public interface Resource {

    InputStream getInputStream() throws FileNotFoundException;

    String getDescription();
}
