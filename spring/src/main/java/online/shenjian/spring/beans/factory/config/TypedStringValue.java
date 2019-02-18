package online.shenjian.spring.beans.factory.config;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/2
 */
public class TypedStringValue {

    private final String value;

    public TypedStringValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
