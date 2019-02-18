package online.shenjian.jvm.cmd;

import online.shenjian.jvm.clz.ClassFile;
import online.shenjian.jvm.engine.ExecutorResult;
import online.shenjian.jvm.engine.Heap;
import online.shenjian.jvm.engine.JavaObject;
import online.shenjian.jvm.engine.StackFrame;

public class BiPushCmd extends OneOperandCmd {

    protected BiPushCmd(ClassFile clzFile, String opCode) {
        super(clzFile, opCode);
    }

    @Override
    public String toString() {
        return getOffset() + ":" + getOpCode() + " " + getReadableCodeText() + " " + getOperand();
    }

    @Override
    public void execute(StackFrame stackFrame, ExecutorResult result) {
        int value = this.getOperand();
        JavaObject jo = Heap.getInstance().newInt(value);
        stackFrame.getOperandStack().push(jo);
    }

}
