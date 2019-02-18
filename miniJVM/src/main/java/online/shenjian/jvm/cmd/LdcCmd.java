package online.shenjian.jvm.cmd;

import online.shenjian.jvm.clz.ClassFile;
import online.shenjian.jvm.constant.ConstantInfo;
import online.shenjian.jvm.constant.StringInfo;
import online.shenjian.jvm.engine.ExecutorResult;
import online.shenjian.jvm.engine.Heap;
import online.shenjian.jvm.engine.JavaObject;
import online.shenjian.jvm.engine.StackFrame;

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
