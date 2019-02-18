package online.shenjian.spring.core.type.classreading;

import online.shenjian.spring.core.type.ClassMetadata;
import online.shenjian.spring.util.ClassUtils;
import org.springframework.asm.ClassVisitor;
import org.springframework.asm.Opcodes;
import org.springframework.asm.SpringAsmInfo;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/1
 */
public class ClassMetadataReadingVisitor extends ClassVisitor implements ClassMetadata {

    private String className;
    private boolean isInterface;
    private boolean isAbstract;
    private boolean isFinal;
    private boolean hasSuperClass;
    private String superClassName;
    private String[] interfaceNames;

    public ClassMetadataReadingVisitor() {
        super(SpringAsmInfo.ASM_VERSION);
    }

    @Override
    public void visit(int version, int access, String name, String signature,
                      String superName, String[] interfaces) {
        this.className = ClassUtils.convertResourcePathToClassName(name);
        this.isInterface = (access & Opcodes.ACC_INTERFACE) != 0;
        this.isAbstract = (access & Opcodes.ACC_ABSTRACT) != 0;
        this.isFinal = (access & Opcodes.ACC_FINAL) != 0;

        if (superName != null) {
            this.hasSuperClass = true;
            this.superClassName = ClassUtils.convertResourcePathToClassName(superName);
        }
        this.interfaceNames = new String[interfaces.length];
        for (int i = 0; i < interfaces.length; i++) {
            interfaceNames[i] = ClassUtils.convertResourcePathToClassName(interfaces[i]);
        }
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public boolean isInterface() {
        return isInterface;
    }

    @Override
    public boolean isAbstract() {
        return isAbstract;
    }

    @Override
    public boolean isFinal() {
        return isFinal;
    }

    @Override
    public boolean hasSuperClass() {
        return hasSuperClass;
    }

    @Override
    public String getSuperClassName() {
        return superClassName;
    }

    @Override
    public String[] getInterfaceNames() {
        return interfaceNames;
    }
}
