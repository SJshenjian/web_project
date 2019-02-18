package online.shenjian.jvm.clz;

import java.util.ArrayList;
import java.util.List;

import online.shenjian.jvm.constant.ConstantPool;
import online.shenjian.jvm.field.Field;
import online.shenjian.jvm.method.Method;

public class ClassFile {

    private int minorVersion;//次版本号
    private int majorVersion;//主版本号

    private ConstantPool constantPool;//常量池

    private AccessFlag accessFlag;//访问标志

    private ClassIndex classIndex;//索引类

    private List<Field> fields = new ArrayList<Field>();//字段表集合

    private List<Method> methods = new ArrayList<Method>();//方法表集合

    /**
     * 获取类名
     *
     * @return
     */
    public String getClassName() {
        int thisClassIndex = this.classIndex.getThisClassIndex();
        //ClassInfo info=(ClassInfo) this.constantPool.getConstantInfo(thisClassIndex);
        //return info.getClassName();
        return this.getConstantPool().getUTF8String(thisClassIndex);//注释代码的简化
    }

    /**
     * 获取父类名
     *
     * @return
     */
    public String getSuperClassName() {
        int superClassIndex = this.classIndex.getSuperClassIndex();
        //ClassInfo info=(ClassInfo) this.constantPool.getConstantInfo(superClassIndex);
        //return info.getClassName();
        return this.constantPool.getUTF8String(superClassIndex);//注释代码的简化
    }

    /**
     * @param methodName         方法名称
     * @param paramAndReturnType 描述(参数与返回类型)
     * @return
     */
    public Method getMethod(String methodName, String paramAndReturnType) {

        for (Method method : methods) {
            int nameIndex = method.getNameIndex();
            int descIndex = method.getDescIndex();

            String name = this.getConstantPool().getUTF8String(nameIndex);
            String desc = this.getConstantPool().getUTF8String(descIndex);

            if (methodName.equals(name) && paramAndReturnType.equals(desc)) {
                return method;
            }
        }
        return null;
    }

    /**
     * 获取Main方法,执行引擎执行的入口
     *
     * @return
     */
    public Method getMainMethod() {

        return getMethod("main", "([Ljava/lang/String;)V");
    }


    /**
     * 以下为其getter setter 方法
     */

    public int getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }


    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public void setConstantPool(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    public AccessFlag getAccessFlag() {
        return accessFlag;
    }

    public void setAccessFlag(AccessFlag accessFlag) {
        this.accessFlag = accessFlag;
    }

    public ClassIndex getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(ClassIndex classIndex) {
        this.classIndex = classIndex;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

}
