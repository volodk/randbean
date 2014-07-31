package org.randbean.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 * 
 */
public class ReflectionUtils {

    public static void set(Object instance, Field field, Object value) {
        boolean wflag = field.isAccessible();
        try {
            field.setAccessible(true);
            try {
                field.set(instance, value);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                System.err.println("Cannot set value, details : " + e.getMessage());
            }
        } finally {
            field.setAccessible(wflag);
        }
    }

    public static Object newInstance(Class<?> clazz) {

        try {
            for (Constructor<?> constr : clazz.getDeclaredConstructors()) {
                if (constr.getGenericParameterTypes().length == 0) {
                    return constr.newInstance(new Object[] {});
                }
            }
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
