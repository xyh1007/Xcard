package com.xyh.game.Util;

import java.lang.reflect.Field;

public class FieldUtil {


    public static String getFieldValueByFieldName(String fieldName,Object object) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            //对private的属性的访问
            field.setAccessible(true);
            return (String)field.get(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setFieldValueByFieldName(String fieldName,Object object,String value) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            //对private的属性的访问
            field.setAccessible(true);
            field.set(object,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
