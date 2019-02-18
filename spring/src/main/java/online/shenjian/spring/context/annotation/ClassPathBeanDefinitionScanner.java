package online.shenjian.spring.context.annotation;

import online.shenjian.spring.beans.BeanDefinition;
import online.shenjian.spring.beans.factory.BeanDefinitionStoreException;
import online.shenjian.spring.beans.factory.support.BeanDefinitionRegistry;
import online.shenjian.spring.beans.factory.support.BeanNameGenerator;
import online.shenjian.spring.core.io.Resource;
import online.shenjian.spring.core.io.support.PackageResourceLoader;
import online.shenjian.spring.core.type.classreading.MetadataReader;
import online.shenjian.spring.core.type.classreading.SimpleMetadataReader;
import online.shenjian.spring.steretype.Component;
import online.shenjian.spring.util.StringUtils;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/19
 */
public class ClassPathBeanDefinitionScanner {

    private BeanDefinitionRegistry registry;
    private PackageResourceLoader resourceLoader = new PackageResourceLoader();

    // @Component未设置value属性时生成默认beanName(首字母小写后的文件名)
    private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public Set<BeanDefinition> doScan(String packagesToScan) {
        String[] basePackages = StringUtils.tokenizeToStringArray(packagesToScan, ",");

        Set<BeanDefinition> beanDefinitions = new LinkedHashSet<>();
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponent(basePackage);
            for (BeanDefinition candidate : candidates) {
                beanDefinitions.add(candidate);
                registry.registryBeanDefinition(candidate.getId(), candidate);
            }
        }
        return beanDefinitions;
    }

    private Set<BeanDefinition> findCandidateComponent(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        try {
            Resource[] resources = this.resourceLoader.getResources(basePackage);
            for (Resource resource : resources) {
                try {
                    MetadataReader metadataReader = new SimpleMetadataReader(resource);
                    if (metadataReader.getAnnotationMetadata().hasAnnotation(Component.class.getName())) {
                        ScannedGenericBeanDefinition scannedGenericBeanDefinition = new ScannedGenericBeanDefinition(metadataReader);
                        String generatedBeanName = this.beanNameGenerator.generateBeanName(scannedGenericBeanDefinition, registry);
                        scannedGenericBeanDefinition.setId(generatedBeanName);
                        candidates.add(scannedGenericBeanDefinition);
                    }
                } catch (Throwable ex) {
                    throw new BeanDefinitionStoreException("Failed to read candidate component class: " + resource, ex);
                }
            }
        }
        catch (IOException ex) {
            throw new BeanDefinitionStoreException("I/O failure during classpath scanning", ex);
        }
        return candidates;
    }
}
