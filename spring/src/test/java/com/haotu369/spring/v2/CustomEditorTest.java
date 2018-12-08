package com.haotu369.spring.v2;

import com.haotu369.spring.beans.propertyeditors.CustomNumberEditor;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/5
 */
public class CustomEditorTest {

    @Test
    public void testCustomNumberEditor() {
        CustomNumberEditor numberEditor = new CustomNumberEditor(Integer.class, true);
        numberEditor.setAsText("3");

        assertTrue(numberEditor.getValue() instanceof Integer);
        assertEquals(3, ((Integer)numberEditor.getValue()).intValue());

        numberEditor.setAsText("");
        assertEquals(null, numberEditor.getValue());

        try {
            numberEditor.setAsText("3.1");
        } catch (IllegalArgumentException e) {
            return ;
        }
        fail();
    }
}
