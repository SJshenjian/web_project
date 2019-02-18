package online.shenjian.spring.core.io.support;

import online.shenjian.spring.core.io.FileSystemResource;
import online.shenjian.spring.core.io.Resource;
import online.shenjian.spring.util.Assert;
import online.shenjian.spring.util.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/1
 */
public class PackageResourceLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(PackageResourceLoader.class);
    private final ClassLoader classLoader;

    public PackageResourceLoader() {
        classLoader = ClassUtils.getDefaultClassLoader();
    }

    public PackageResourceLoader(ClassLoader classLoader) {
        Assert.notNull(classLoader, "ResourceLoader must not be null");
        this.classLoader = classLoader;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public Resource[] getResources(String basePackage) throws IOException {
        Assert.notNull(basePackage, "BasePackage must not be null");
        String location = ClassUtils.convertClassNameToResourcePath(basePackage);
        URL url  = getClassLoader().getResource(location);

        File rootFile = new File(url.getFile());
        Set<File> matchingFile = retrieveMatchingFiles(rootFile);
        Resource[] result = new Resource[matchingFile.size()];

        int i = 0;
        for (File file : matchingFile) {
            result[i++] = new FileSystemResource(file);
        }
        return result;
    }

    protected Set<File> retrieveMatchingFiles(File rootDir) {
        if (!rootDir.exists()) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Skipping [" + rootDir.getAbsolutePath() + "] because it does not exist");
            }
            return Collections.emptySet();
        }
        if (!rootDir.isDirectory()) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Skipping [" + rootDir.getAbsolutePath() + "] because it does not a directory");
            }
            return Collections.emptySet();
        }
        if (!rootDir.canRead()) {
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn("Cannot search for matching files underneath directory [" + rootDir.getAbsolutePath() +
                        "] because the application is not allowed to read the directory");
            }
            return Collections.emptySet();
        }

        Set<File> result = new LinkedHashSet<>(8);
        doRetrieveMatchingFiles(rootDir, result);
        return result;
    }

    protected void doRetrieveMatchingFiles(File rootDir, Set<File> result) {
        File[] dirContents = rootDir.listFiles();
        if (dirContents == null) {
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn("Could not retrieve contents of directory [" + rootDir.getAbsolutePath() + "]");
            }
        }

        for (File file: dirContents) {
            if (file.isDirectory()) {
                if (!file.canRead()) {
                    if (LOGGER.isDebugEnabled()) {
                        LOGGER.debug("Skipping subdirectory [" + file.getAbsolutePath() +
                                "] because the application is not allowed to read the directory");
                    }
                } else {
                    doRetrieveMatchingFiles(rootDir, result);
                }
            } else {
                result.add(file);
            }
        }
    }
}
