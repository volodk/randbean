package org.randbean.values;

import org.randbean.core.CreationMode;
import org.randbean.types.Randomizable;
import org.randbean.utils.Preconditions;

class NullValue implements Randomizable {
    
    public static final Randomizable instance = new NullValue();
    
    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Preconditions.notNull(clazz);
        return null;
    }

}
