package online.shenjian.spring.core.io;

import online.shenjian.spring.util.Assert;
import online.shenjian.spring.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/16
 */
public class ClassPathResource implements Resource {

    private final String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        InputStream inputStream = classLoader.getResourceAsStream(path);
        if (inputStream == null) {
            throw new FileNotFoundException("Path cannot be opened because it does not exist");
        }
        return inputStream;
    }

    @Override
    public String getDescription() {
        return "Path is [" + path + "]";
    }
}
