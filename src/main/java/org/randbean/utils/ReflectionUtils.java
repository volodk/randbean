package org.randbean.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

import org.randbean.core.CreationMode;
import org.randbean.values.RandomizableValue;
import org.randbean.values.ValueFactory;

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

    @SuppressWarnings("unchecked")
    public static <T> T newInstance(Class<T> clazz) {
        Objects.requireNonNull(clazz);
        
        if (clazz.isInterface()) {
            return null;
        }
        
        try {
            Constructor<?> c = null;
            int n = clazz.getConstructors().length;
            if (n > 1) {
                Constructor<?> constuctors[] = Arrays.copyOf(clazz.getConstructors(), n);
                Arrays.sort(constuctors, new Comparator<Constructor<?>>() {
                    @Override
                    public int compare(Constructor<?> c1, Constructor<?> c2) {
                        int argList1 = c1.getGenericParameterTypes().length;
                        int argList2 = c2.getGenericParameterTypes().length;
                        return Integer.compare(argList1, argList2);
                    }
                });
                c = constuctors[0];
            } else if (n == 1) {
                c = clazz.getConstructors()[0];
            } else {
                c = clazz.getDeclaredConstructors()[0];
            }
            return (T) createWithConstructor(c);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Object createWithConstructor(Constructor<?> c) throws InstantiationException,
            IllegalAccessException, InvocationTargetException {

        Class<?>[] types = c.getParameterTypes();
        int N = types.length;
        Object[] params = new Object[N];
        for (int i = 0; i < N; i++) {
            RandomizableValue r = ValueFactory.resolve(types[i]);
            params[i] = r.instantiate(types[i], CreationMode.SHALLOW);
        }
        return c.newInstance(params);
    }

}
