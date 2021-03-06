package org.randbean.values;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.randbean.core.CreationMode;

class RandomizedJdkObject implements RandomizableValue {

    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Objects.requireNonNull(clazz);

        if( Map.class.isAssignableFrom(clazz) ) return new RandomizedMap().instantiate(clazz, mode);
        if( Set.class.isAssignableFrom(clazz) ) return new RandomizedSet().instantiate(clazz, mode);
        if( List.class.isAssignableFrom(clazz) ) return new RandomizedList().instantiate(clazz, mode);

        return null;
        
    }
}
