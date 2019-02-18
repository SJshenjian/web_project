package online.shenjian.spring.core.type.classreading;

import online.shenjian.spring.core.annotation.AnnotationAttributes;
import org.springframework.asm.AnnotationVisitor;
import org.springframework.asm.SpringAsmInfo;

import java.util.Map;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/19
 */
final class AnnotationAttributesReadingVisitor extends AnnotationVisitor {

    private final Map<String, AnnotationAttributes> attributesMap;
    private final String attributeType;
    private AnnotationAttributes attributes = new AnnotationAttributes();

    public AnnotationAttributesReadingVisitor(String attributeType, Map<String, AnnotationAttributes> attributesMap) {
        super(SpringAsmInfo.ASM_VERSION);
        this.attributeType = attributeType;
        this.attributesMap = attributesMap;
    }

    @Override
    public void visit(String attributeName, Object attributeValue) {
        this.attributes.put(attributeName, attributeValue);
    }

    @Override
    public final void visitEnd() {
        this.attributesMap.put(attributeType, attributes);
    }
}
