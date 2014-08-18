package org.randbean.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;

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

    public static void setIfNull(Object instance, Field field, Object value) {
        try {
            if (field.get(instance) == null) {
                boolean wflag = field.isAccessible();
                try {
                    field.setAccessible(true);
                    field.set(instance, value);
                } finally {
                    field.setAccessible(wflag);
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            System.err.println("Cannot set value, details : " + e.getMessage());
        }
    }

    public static Object newInstance(Class<?> clazz) {
        try {
            Constructor<?> c = null;
            int n = clazz.getConstructors().length;
            if (n > 1) {
                Constructor<?> constuctors[] = Arrays.copyOf(clazz.getConstructors(), n);
                Arrays.sort(constuctors, new Comparator<Constructor<?>>() {
                    @Override
                    public int compare(Constructor<?> c1, Constructor<?> c2) {
                        return c2.getGenericParameterTypes().length - c1.getGenericParameterTypes().length;
                    }
                });
                c = constuctors[0];
            } else if (n == 1) {
                c = clazz.getConstructors()[0];
            } else {
                c = clazz.getDeclaredConstructors()[0];
            }

            return createWithConstructor(c);

        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object createWithConstructor(Constructor<?> c) throws InstantiationException,
            IllegalAccessException, InvocationTargetException {
        return c.newInstance(new Object[]{});
    }

}
