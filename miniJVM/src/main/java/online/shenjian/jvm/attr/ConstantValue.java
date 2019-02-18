package online.shenjian.jvm.attr;

public class ConstantValue extends AttributeInfo {

    private int constantValueIndex;

    public ConstantValue(int attrNameIndex, int attrLen) {
        super(attrNameIndex, attrLen);
    }

    public int getConstantValueIndex() {
        return constantValueIndex;
    }

    public void setConstantValueIndex(int constantValueIndex) {
        this.constantValueIndex = constantValueIndex;
    }

}
