package com.haotu369.jvm.cmd;

import com.haotu369.jvm.clz.ClassFile;
import com.haotu369.jvm.constant.ClassInfo;
import com.haotu369.jvm.engine.ExecutorResult;
import com.haotu369.jvm.engine.Heap;
import com.haotu369.jvm.engine.JavaObject;
import com.haotu369.jvm.engine.StackFrame;

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
