package org.randbean.values;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.randbean.types.Randomizable;
import org.randbean.utils.Preconditions;

class RandomizedJdkObject implements Randomizable {

    @Override
    public Object instantiate(Class<?> clazz, boolean followReferences) {
        Preconditions.notNull(clazz);

        if( Map.class.isAssignableFrom(clazz) ) return new RandomizedMap().instantiate(clazz, followReferences);
        if( Set.class.isAssignableFrom(clazz) ) return new RandomizedSet().instantiate(clazz, followReferences);
        if( List.class.isAssignableFrom(clazz) ) return new RandomizedList().instantiate(clazz, followReferences);

        return null;
        
    }
}
