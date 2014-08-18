package org.randbean.values;

import org.randbean.types.Randomizable;
import org.randbean.utils.Preconditions;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 2:36:18 PM 

class RandomizedList implements Randomizable {

    @Override
    public Object instantiate(Class<?> clazz, boolean followReferences) {
        Preconditions.notNull(clazz);
        return null;
    }

}
