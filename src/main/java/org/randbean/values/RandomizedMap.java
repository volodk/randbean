package org.randbean.values;

import org.randbean.core.CreationMode;
import org.randbean.types.Randomizable;
import org.randbean.utils.Preconditions;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 2:36:05 PM 

class RandomizedMap implements Randomizable {

    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Preconditions.notNull(clazz);
        return null;
    }

}
