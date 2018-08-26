package com.haotu369.jvm.cmd;

import com.haotu369.jvm.clz.ClassFile;
import com.haotu369.jvm.engine.ExecutorResult;
import com.haotu369.jvm.engine.Heap;
import com.haotu369.jvm.engine.JavaObject;
import com.haotu369.jvm.engine.StackFrame;

public class IncrementCmd extends TwoOperandCmd {

    protected IncrementCmd(ClassFile clzFile, String opCode) {
        super(clzFile, opCode);
    }

    @Override
    public String toString() {
        return this.getOffset() + ":" + this.getOpCode() + " " + this.getReadableCodeText();
    }

    @Override
    public void execute(StackFrame stackFrame, ExecutorResult result) {

        int index = this.getOperand1();

        int constValue = this.getOperand2();

        int currentValue = stackFrame.getLocalVariableValue(index).getIntValue();

        JavaObject jo = Heap.getInstance().newInt(currentValue + constValue);

        stackFrame.setLocalVariableValue(index, jo);

    }

}
