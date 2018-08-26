package com.haotu369.jvm.cmd;

import com.haotu369.jvm.clz.ClassFile;
import com.haotu369.jvm.engine.ExecutorResult;
import com.haotu369.jvm.engine.StackFrame;

public abstract class OneOperandCmd extends ByteCodeCommand {

    int operand;

    protected OneOperandCmd(ClassFile clzFile, String opCode) {
        super(clzFile, opCode);
    }

    public int getLength() {
        return 2;
    }

    public int getOperand() {
        return operand;
    }

    public void setOperand(int operand) {
        this.operand = operand;
    }
}
