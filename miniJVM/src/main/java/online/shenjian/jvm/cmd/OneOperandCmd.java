package online.shenjian.jvm.cmd;

import online.shenjian.jvm.clz.ClassFile;

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
