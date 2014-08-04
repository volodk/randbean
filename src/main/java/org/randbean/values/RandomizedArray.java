package org.randbean.values;

import java.util.Arrays;
import java.util.Random;

import org.randbean.types.Randomizable;
import org.randbean.utils.ArrayUtils;
import org.randbean.utils.Preconditions;

class RandomizedArray implements Randomizable {

    private static final Random RND = new Random();
    private static final int MAX_DIMENTION_SIZE = Integer.parseInt(System.getProperty("arrays.max.size", "5"));

    private Class<?> clazz;

    public RandomizedArray(Class<?> clazz) {
        Preconditions.notNull(clazz);
        Preconditions.assertThat(clazz.isArray(), new IllegalArgumentException("Unsupported classtype, class : "
                + clazz));
        this.clazz = clazz;
    }

    @Override
    public Object generate() {

        int d = ArrayUtils.countArrayDimensions(clazz);
        int[] dimensions = new int[d];
        int i = d;
        while (--i >= 0) {
            dimensions[i] = 1 + RND.nextInt(MAX_DIMENTION_SIZE);
        }

        Class<?> componentType = ArrayUtils.getComponentType(clazz);

        Randomizable rv = ValueFactory.resolve(componentType);

        return fill(componentType, rv, dimensions, 0, d);
    }

    private Object fill(final Class<?> clazz, final Randomizable rv, int[] dimensions, int from, int to) {
        if (from < to) {
            Object array = java.lang.reflect.Array.newInstance(clazz, Arrays.copyOfRange(dimensions, from, to));
            for (int i = 0; i < dimensions[from]; i++) {
                Object value = fill(clazz, rv, dimensions, from + 1, to);
                java.lang.reflect.Array.set(array, i, value);
            }
            return array;
        } else {
            return rv.generate();
        }
    }

}
