package org.randbean.values;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import org.randbean.core.CreationMode;
import org.randbean.types.Randomizable;
import org.randbean.utils.ArrayUtils;
import org.randbean.utils.Preconditions;

class RandomizedArray implements Randomizable {

    private static final Random RND = new Random();
    private static final int MAX_DIMENTION_SIZE = Integer.parseInt(System.getProperty("arrays.max.size", "5"));

    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Preconditions.notNull(clazz);
        
        int d = ArrayUtils.countArrayDimensions(clazz);
        int[] dimensions = new int[d];
        int i = d;
        while (--i >= 0) {
            dimensions[i] = 1 + RND.nextInt(MAX_DIMENTION_SIZE);
        }

        Class<?> componentType = ArrayUtils.getComponentType(clazz);
        Randomizable rv = ValueFactory.resolve(componentType);
        
        return fill(componentType, rv, dimensions, 0, d, mode);
    }

    private Object fill(final Class<?> clazz, final Randomizable rv, int[] dimensions, int from, int to, CreationMode mode) {
        if (from < to) {
            Object array = Array.newInstance(clazz, Arrays.copyOfRange(dimensions, from, to));
            for (int i = 0; i < dimensions[from]; i++) {
                Object value = fill(clazz, rv, dimensions, from + 1, to, mode);
                Array.set(array, i, value);
            }
            return array;
        } else {
            return rv.instantiate(clazz, mode);
        }
    }

}
