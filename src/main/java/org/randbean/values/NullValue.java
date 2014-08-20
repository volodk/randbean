package org.randbean.values;

import java.util.Objects;

import org.randbean.core.CreationMode;
import org.randbean.types.Randomizable;

class NullValue implements Randomizable {
    
    public static final Randomizable instance = new NullValue();
    
    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Objects.requireNonNull(clazz);
        return null;
    }

}
