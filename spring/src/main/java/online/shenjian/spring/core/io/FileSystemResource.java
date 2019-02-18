package online.shenjian.spring.core.io;

import online.shenjian.spring.util.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/16
 */
public class FileSystemResource implements Resource {

    private final File file;

    public FileSystemResource(File file) {
        Assert.notNull(file, "File must not be null");
        this.file = file;
    }

    public FileSystemResource(String path) {
        Assert.notNull(path, "Path must not be null");
        file = new File(path);
    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        return new FileInputStream(file);
    }

    @Override
    public String getDescription() {
        return "file [" + this.file.getAbsolutePath() + "]";
    }
}
