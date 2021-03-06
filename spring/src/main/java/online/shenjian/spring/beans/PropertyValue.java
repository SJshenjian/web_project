package online.shenjian.spring.beans;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/2
 */
public class PropertyValue {

    private final String name;
    private final Object value;
    private boolean converted = false;
    private Object convertedValue;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public synchronized boolean isConverted() {
        return converted;
    }

    public synchronized void setConverted(boolean converted) {
        this.converted = converted;
    }

    public synchronized Object getConvertedValue() {
        return convertedValue;
    }
}
