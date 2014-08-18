package org.randbean.values;

import org.randbean.types.Randomizable;
import org.randbean.utils.Preconditions;

class NullValue implements Randomizable {
    
    public static final Randomizable instance = new NullValue();
    
    @Override
    public Object instantiate(Class<?> clazz, boolean followReferences) {
        Preconditions.notNull(clazz);
        return null;
    }

}
