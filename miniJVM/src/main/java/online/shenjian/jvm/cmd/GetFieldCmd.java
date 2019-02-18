package online.shenjian.jvm.cmd;

import online.shenjian.jvm.clz.ClassFile;
import online.shenjian.jvm.constant.FieldRefInfo;
import online.shenjian.jvm.engine.ExecutorResult;
import online.shenjian.jvm.engine.JavaObject;
import online.shenjian.jvm.engine.StackFrame;


public class GetFieldCmd extends TwoOperandCmd {

    protected GetFieldCmd(ClassFile clzFile, String opCode) {
        super(clzFile, opCode);
    }

    @Override
    public String toString() {
        return super.getOperandAsField();
    }

    @Override
    public void execute(StackFrame stackFrame, ExecutorResult result) {

        FieldRefInfo fieldRef = (FieldRefInfo) this.getConstantInfo(getIndex());
        String fieldName = fieldRef.getFieldName();

        JavaObject jo = stackFrame.getOperandStack().pop();
        JavaObject fieldValue = jo.getFieldValues(fieldName);

        stackFrame.getOperandStack().push(fieldValue);

    }
}
