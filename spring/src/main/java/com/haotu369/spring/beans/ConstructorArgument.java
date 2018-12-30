package com.haotu369.spring.beans;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/9
 */
public class ConstructorArgument {

    private List<ValueHolder> valueHolders  = new LinkedList<>();

    public ConstructorArgument() {

    }

    public void addArgumentValue(ValueHolder valueHolder) {
        this.valueHolders.add(valueHolder);
    }

    public List<ValueHolder> getArgumentValues() {
        return Collections.unmodifiableList(valueHolders);
    }

    public int getArgumentCount() {
        return valueHolders.size();
    }

    public boolean isEmpty() {
        return valueHolders.isEmpty();
    }

    public void clear() {
        valueHolders.clear();
    }

    public static class ValueHolder {

        private Object value;
        private String type;
        private String name;

        public ValueHolder(Object value) {
            this.value = value;
        }

        public ValueHolder(Object value, String type) {
            this.value = value;
            this.type = type;
        }

        public ValueHolder(Object value, String type, String name) {
            this.value = value;
            this.type = type;
            this.name = name;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getValue() {
            return value;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }
}
