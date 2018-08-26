package com.haotu369.jvm.cmd;

import com.haotu369.jvm.clz.ClassFile;
import com.haotu369.jvm.constant.ConstantInfo;
import com.haotu369.jvm.constant.StringInfo;
import com.haotu369.jvm.engine.ExecutorResult;
import com.haotu369.jvm.engine.Heap;
import com.haotu369.jvm.engine.JavaObject;
import com.haotu369.jvm.engine.StackFrame;

public class LdcCmd extends OneOperandCmd {

    protected LdcCmd(ClassFile clzFile, String opCode) {
        super(clzFile, opCode);
    }

    @Override
    public String toString() {

        ConstantInfo info = this.getConstantInfo(getOperand());

        String value = "TBD";
        if (info instanceof StringInfo) {
            StringInfo strInfo = (StringInfo) info;
            value = strInfo.toString();
        }

        return this.getOffset() + ":" + this.getOpCode() + " " + this.getReadableCodeText() + "  " + value;
    }

    @Override
    public void execute(StackFrame stackFrame, ExecutorResult result) {
        ConstantInfo constantInfo = this.getConstantInfo(getOperand());

        if (constantInfo instanceof StringInfo) {
            StringInfo stringInfo = (StringInfo) constantInfo;

            String value = stringInfo.toString();
            JavaObject jo = Heap.getInstance().newString(value);

            stackFrame.getOperandStack().push(jo);
        } else {
            //TBD 处理其他类型
            throw new RuntimeException("Only support StringInfo constant");
        }
    }
}
