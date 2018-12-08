package com.haotu369.spring.beans;

import com.haotu369.spring.beans.propertyeditors.CustomBooleanEditor;
import com.haotu369.spring.beans.propertyeditors.CustomNumberEditor;
import com.haotu369.spring.util.ClassUtils;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/6
 */
public class SimpleTypeConverter implements TypeConverter {

    private Map<Class<?>, PropertyEditor> defaultEditors;

    public SimpleTypeConverter() {}

    @Override
    public <T> T convertIfNecessary(Object value, Class<T> requiredType) throws TypeMismatchException {
       if (ClassUtils.isAssignableValue(requiredType, value)) {
           return (T)value;
       }

       if (value instanceof String) {
           PropertyEditor propertyEditor = this.findDefaultEditor(requiredType);
           if (propertyEditor != null) {
               try {
                   propertyEditor.setAsText((String) value);
               } catch (IllegalArgumentException e) {
                   throw new TypeMismatchException(value, requiredType);
               }
               return (T) propertyEditor.getValue();
           }
       }
        throw new RuntimeException("Todo: can't convert value " + value + " to class: " + requiredType);
    }

    public PropertyEditor getDefaultEditor(Class<?> requiredType) {
        PropertyEditor editor = this.findDefaultEditor(requiredType);
        if (editor == null) {
            throw new RuntimeException("Editor for " + requiredType + " has not been implemented");
        }
        return editor;
    }

    private PropertyEditor findDefaultEditor(Class<?> requiredType) {
        if (this.defaultEditors == null) {
            createDefaultEditors();
        }
        return defaultEditors.get(requiredType);
    }

    private void createDefaultEditors() {
        this.defaultEditors = new HashMap<>(64);

        this.defaultEditors.put(boolean.class, new CustomBooleanEditor(false));
        this.defaultEditors.put(Boolean.class, new CustomBooleanEditor(true));

        this.defaultEditors.put(int.class, new CustomNumberEditor(Integer.class, false));
        this.defaultEditors.put(Integer.class, new CustomNumberEditor(Integer.class, true));
    }
}
