package online.shenjian.jvm.cmd;

import online.shenjian.jvm.clz.ClassFile;
import online.shenjian.jvm.constant.ClassInfo;
import online.shenjian.jvm.engine.ExecutorResult;
import online.shenjian.jvm.engine.Heap;
import online.shenjian.jvm.engine.JavaObject;
import online.shenjian.jvm.engine.StackFrame;

public class NewObjectCmd extends TwoOperandCmd {

    protected NewObjectCmd(ClassFile clzFile, String opCode) {
        super(clzFile, opCode);
    }

    @Override
    public String toString() {
        return this.getOperandAsClassInfo();
    }

    @Override
    public void execute(StackFrame stackFrame, ExecutorResult result) {

        int index = this.getIndex();

        ClassInfo clzInfo = (ClassInfo) this.getConstantInfo(index);

        String className = clzInfo.getClassName();

        JavaObject jo = Heap.getInstance().newObject(className);

        stackFrame.getOperandStack().push(jo);
    }

}
