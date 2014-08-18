package org.randbean.values;

import org.randbean.types.Randomizable;
import org.randbean.utils.ArrayUtils;
import org.randbean.utils.Preconditions;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:44:56 PM 

class RandomizedEnum implements Randomizable {
    
    @Override
    public Object instantiate(Class<?> clazz, boolean followReferences) {
        Preconditions.notNull(clazz);
        return ArrayUtils.randomElement(clazz.getEnumConstants());
    }
}
