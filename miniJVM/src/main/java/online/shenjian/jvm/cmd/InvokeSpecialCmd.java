package online.shenjian.jvm.cmd;

import online.shenjian.jvm.clz.ClassFile;
import online.shenjian.jvm.constant.MethodRefInfo;
import online.shenjian.jvm.engine.ExecutorResult;
import online.shenjian.jvm.engine.MethodArea;
import online.shenjian.jvm.engine.StackFrame;
import online.shenjian.jvm.method.Method;

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
