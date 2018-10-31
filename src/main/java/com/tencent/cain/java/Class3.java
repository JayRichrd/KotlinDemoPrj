package com.tencent.cain.java;

import java.lang.reflect.Field;

/**
 * @author cainjiang
 * @date 2018/10/30
 */
public class Class3 extends Class2 {
    public int getAge() {
        Field field = null;
        try {
            field = this.getClass().getSuperclass().getDeclaredField("age");
            field.setAccessible(true);
            return field.getInt(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
}
