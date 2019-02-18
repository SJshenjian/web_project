package online.shenjian.jvm.cmd;

import online.shenjian.jvm.clz.ClassFile;
import online.shenjian.jvm.engine.ExecutorResult;
import online.shenjian.jvm.engine.JavaObject;
import online.shenjian.jvm.engine.StackFrame;

public class ComparisonCmd extends TwoOperandCmd {

    protected ComparisonCmd(ClassFile clzFile, String opCode) {
        super(clzFile, opCode);
    }

    @Override
    public void execute(StackFrame stackFrame, ExecutorResult result) {

        if (if_icmp_ge.equals(this.getOpCode())) {
            //注意次序
            JavaObject jo2 = stackFrame.getOperandStack().pop();
            JavaObject jo1 = stackFrame.getOperandStack().pop();

            if (jo1.getIntValue() >= jo2.getIntValue()) {

                this.setJumpResult(result);

            }

        } else if (if_icmple.equals(this.getOpCode())) {
            //注意次序
            JavaObject jo2 = stackFrame.getOperandStack().pop();
            JavaObject jo1 = stackFrame.getOperandStack().pop();

            if (jo1.getIntValue() <= jo2.getIntValue()) {
                this.setJumpResult(result);
            }

        } else if (goto_no_condition.equals(this.getOpCode())) {
            this.setJumpResult(result);

        } else {
            throw new RuntimeException(this.getOpCode() + "has not been implemented");
        }


    }

    private int getOffsetFromStartCmd() {
        //If the comparison succeeds, the unsigned branchbyte1 and branchbyte2
        //are used to construct a signed 16-bit offset, where the offset is calculated
        //to be (branchbyte1 << 8) | branchbyte2. Execution then proceeds at that
        //offset from the address of the opcode of this if_icmp<cond> instruction


        int index1 = this.getOperand1();
        int index2 = this.getOperand2();
        short offsetFromCurrent = (short) (index1 << 8 | index2);
        return this.getOffset() + offsetFromCurrent;
    }

    private void setJumpResult(ExecutorResult result) {

        int offsetFromStartCmd = this.getOffsetFromStartCmd();

        result.setNextAction(ExecutorResult.JUMP);
        result.setNextCmdOffset(offsetFromStartCmd);
    }

    @Override
    public String toString() {
        String text = this.getReadableCodeText();
        return this.getOffset() + ":" + this.getOpCode() + " " + text + " " + this.getOffsetFromStartCmd();
    }
}