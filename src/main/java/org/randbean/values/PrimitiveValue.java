package org.randbean.values;

import java.util.Random;

import org.randbean.types.Randomizable;
import org.randbean.utils.Preconditions;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 * 
 */

class PrimitiveValue implements Randomizable {

    private static final Random RND = new Random();
    private static final int MAX_INT = 100;

    private Class<?> clazz;

    public PrimitiveValue(Class<?> clazz) {
        Preconditions.notNull(clazz);
        Preconditions.assertThat(clazz.isPrimitive(), new IllegalArgumentException("Is not a primitive, class : " + clazz));
        this.clazz = clazz;
    }

    @Override
    public Object generate() {
        switch (clazz.toString()) {
            case "byte":
                return (byte) (RND.nextInt(Byte.MAX_VALUE) & 0xFF);
            case "short":
                return (short) (RND.nextInt(Short.MAX_VALUE) & 0xFFFF);
            case "int":
                return RND.nextInt(MAX_INT);
            case "long":
                return RND.nextLong();
            case "float":
                return RND.nextFloat();
            case "double":
                return RND.nextDouble();
            case "char":
                char ch = 0;
                do {
                    ch = (char) ('A' + RND.nextInt('z' - 'A' + 1));
                } while (ch > 'Z' && ch < 'a');
                return ch;
            case "boolean":
                return RND.nextBoolean();
            default:
                return null;
        }
    }

}