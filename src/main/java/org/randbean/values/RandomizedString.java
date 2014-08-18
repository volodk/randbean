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

class RandomizedString implements Randomizable {

    private static final Random RND = new Random();
    private static final int MAX_LENGTH = Integer.parseInt(System.getProperty("strings.max.size", "20"));

    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Preconditions.notNull(clazz);
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
