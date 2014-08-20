package org.randbean.values;

import java.util.Objects;

import org.randbean.core.CreationMode;
import org.randbean.types.Randomizable;
import org.randbean.utils.ReflectionUtils;

class RandomizedDate implements Randomizable {

    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Objects.requireNonNull(clazz);
        return ReflectionUtils.newInstance(clazz);
    }

}
