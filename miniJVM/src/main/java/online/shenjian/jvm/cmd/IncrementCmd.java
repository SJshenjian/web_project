package online.shenjian.jvm.cmd;

import online.shenjian.jvm.clz.ClassFile;
import online.shenjian.jvm.engine.ExecutorResult;
import online.shenjian.jvm.engine.Heap;
import online.shenjian.jvm.engine.JavaObject;
import online.shenjian.jvm.engine.StackFrame;

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
