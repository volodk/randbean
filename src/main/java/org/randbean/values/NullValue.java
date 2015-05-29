package org.randbean.values;

import org.randbean.core.CreationMode;

class NullValue implements RandomizableValue {
    
    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        return null;
    }

}
