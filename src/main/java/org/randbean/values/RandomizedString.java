package org.randbean.values;

import java.util.Random;

import org.randbean.types.Randomizable;
import org.randbean.utils.Preconditions;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 * 
 */

class RandomizedString implements Randomizable {

    private static final Random RND = new Random();
    private static final int MAX_LENGTH = Integer.parseInt(System.getProperty("strings.max.size", "20"));


    public RandomizedString(Class<?> clazz) {
        Preconditions.notNull(clazz);
        Preconditions.assertThat(clazz == java.lang.String.class, new IllegalArgumentException(
                "Is not a java String, class : " + clazz));
    }

    public RandomizedString() {
    }

    @Override
    public Object generate() {
        int length = 1 + RND.nextInt(MAX_LENGTH);
        char[] buff = new char[length];
        for (int i = 0; i < length; i++) {
            char ch = 0;
            do {
                ch = (char) ('A' + RND.nextInt('z' - 'A' + 1));
            } while (ch > 'Z' && ch < 'a');
            buff[i] = ch;
        }
        return java.lang.String.valueOf(buff);
    }

}
