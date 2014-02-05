package org.nicebean.utils;

import java.lang.reflect.Field;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 * 
 */
public class BeanUtils {

    public static void setSilently(Field field, Object instance, Object value) {
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

    public static Object newInstance(Class<?> clazz) throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
        //TODO: handle classes without null-args constructors 
    }

}
