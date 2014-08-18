package org.randbean.values;

import java.util.Random;

import org.randbean.core.CreationMode;
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

    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Preconditions.notNull(clazz);
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
