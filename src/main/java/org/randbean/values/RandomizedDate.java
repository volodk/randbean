package org.randbean.values;

import org.randbean.core.CreationMode;
import org.randbean.types.Randomizable;
import org.randbean.utils.Preconditions;
import org.randbean.utils.ReflectionUtils;

class RandomizedDate implements Randomizable {

    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Preconditions.notNull(clazz);
        return ReflectionUtils.newInstance(clazz);
    }

}
