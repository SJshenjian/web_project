package online.shenjian.spring.v4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/1
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        PackageResourceLoaderTestV4.class,
        ClassReaderTestV4.class,
        MetadataReaderTestV4.class,
        ClassPathBeanDefinitionScannerTestV4.class,
        XmlBeanDefinitionReaderTestV4.class,
        ApplicationContextTestV4.class
})
public class SuiteTestV4 {
}
