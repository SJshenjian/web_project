package online.shenjian.spring.core.type.classreading;

import online.shenjian.spring.core.io.Resource;
import online.shenjian.spring.core.type.AnnotationMetadata;
import online.shenjian.spring.core.type.ClassMetadata;
import org.springframework.asm.ClassReader;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/19
 */
public class SimpleMetadataReader implements MetadataReader {

    private final Resource resource;
    private final ClassMetadata classMetadata;
    private final AnnotationMetadata annotationMetadata;

    public SimpleMetadataReader(Resource resource) throws IOException{

        try (
                InputStream inputStream =  new BufferedInputStream(resource.getInputStream());
        ) {
            ClassReader classReader = new ClassReader(inputStream);
            AnnotationMetadataReadingVisitor visitor = new AnnotationMetadataReadingVisitor();
            classReader.accept(visitor, ClassReader.SKIP_DEBUG);

            this.resource = resource;
            this.classMetadata = visitor;
            this.annotationMetadata = visitor;
        }
    }

    @Override
    public Resource getResource() {
        return this.resource;
    }

    @Override
    public ClassMetadata getClassMetadata() {
        return this.classMetadata;
    }

    @Override
    public AnnotationMetadata getAnnotationMetadata() {
       return this.annotationMetadata;
    }
}
