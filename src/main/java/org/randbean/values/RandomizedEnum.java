package org.randbean.values;

import java.util.Objects;

import org.randbean.core.CreationMode;
import org.randbean.types.Randomizable;
import org.randbean.utils.ArrayUtils;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:44:56 PM 

class RandomizedEnum implements Randomizable {
    
    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Objects.requireNonNull(clazz);
        return ArrayUtils.randomElement(clazz.getEnumConstants());
    }
}
