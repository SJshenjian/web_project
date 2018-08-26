package com.haotu369.jvm.cmd;

import com.haotu369.jvm.clz.ClassFile;
import com.haotu369.jvm.constant.MethodRefInfo;
import com.haotu369.jvm.engine.ExecutorResult;
import com.haotu369.jvm.engine.Heap;
import com.haotu369.jvm.engine.MethodArea;
import com.haotu369.jvm.engine.StackFrame;
import com.haotu369.jvm.method.Method;

public class InvokeSpecialCmd extends TwoOperandCmd {

    protected InvokeSpecialCmd(ClassFile clzFile, String opCode) {
        super(clzFile, opCode);
    }

    @Override
    public String toString() {
        return super.getOperandAsMethod();
    }

    @Override
    public void execute(StackFrame stackFrame, ExecutorResult result) {

        MethodRefInfo methodRef = (MethodRefInfo) this.getConstantInfo(getIndex());

        // 我们不用实现jang.lang.Object 的init方法
        if (methodRef.getClassName().equals("java/lang/Object")
                && methodRef.getMethodName().equals("<init>")) {
            return;
        }

        Method nextMethod = MethodArea.getInstance().getMethod(methodRef);

        result.setNextMethod(nextMethod);
        result.setNextAction(ExecutorResult.PAUSE_AND_RUN_NEW_FRAME);
    }
}
