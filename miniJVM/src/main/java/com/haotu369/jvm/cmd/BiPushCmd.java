package com.haotu369.jvm.cmd;

import com.haotu369.jvm.clz.ClassFile;
import com.haotu369.jvm.engine.ExecutorResult;
import com.haotu369.jvm.engine.Heap;
import com.haotu369.jvm.engine.JavaObject;
import com.haotu369.jvm.engine.StackFrame;

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
