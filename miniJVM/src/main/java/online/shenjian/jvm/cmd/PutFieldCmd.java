package online.shenjian.jvm.cmd;

import online.shenjian.jvm.clz.ClassFile;
import online.shenjian.jvm.constant.FieldRefInfo;
import online.shenjian.jvm.constant.NameAndTypeInfo;
import online.shenjian.jvm.engine.ExecutorResult;
import online.shenjian.jvm.engine.JavaObject;
import online.shenjian.jvm.engine.StackFrame;

public class PutFieldCmd extends TwoOperandCmd {

    protected PutFieldCmd(ClassFile clzFile, String opCode) {
        super(clzFile, opCode);
    }

    @Override
    public String toString() {
        return super.getOperandAsField();
    }

    @Override
    public void execute(StackFrame stackFrame, ExecutorResult result) {

        FieldRefInfo fieldRefInfo = (FieldRefInfo) this.getConstantInfo(getIndex());

        NameAndTypeInfo nameAndTypeInfo = (NameAndTypeInfo) this.getConstantInfo(fieldRefInfo.getNameAndTypeIndex());

        // for example : name
        String fieldName = nameAndTypeInfo.getName();
        // for example : Ljava/lang/String : 注意：我们不再检查类型
        //String fieldType=nameAndTypeInfo.getTypeInfo();

        JavaObject fieldValue = stackFrame.getOperandStack().pop();
        JavaObject objectRef = stackFrame.getOperandStack().pop();

        objectRef.setFieldValues(fieldName, fieldValue);
    }
}