package org.randbean.values;

import org.randbean.types.Randomizable;
import org.randbean.utils.ArrayUtils;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:44:56 PM 

public class Enum implements Randomizable {
    
    private Class<?> clazz;

    public Enum(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object generate() {
        if (clazz.isEnum()) {
            return ArrayUtils.randomElement(clazz.getEnumConstants());
        }
        return null;
    }
}
