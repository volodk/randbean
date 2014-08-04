package org.randbean.values;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.randbean.types.Randomizable;
import org.randbean.utils.Preconditions;

class RandomizedJdkObject implements Randomizable {

    private Class<?> clazz;
    
    public RandomizedJdkObject(Class<?> clazz) {
        Preconditions.notNull(clazz);
        this.clazz = clazz;
    }

    @Override
    public Object generate() {
        if( String.class.equals(clazz) )
            return new RandomizedString().generate();
        if( Date.class.isAssignableFrom(clazz) )
            return new RandomizedDate(clazz).generate();
        if( Map.class.isAssignableFrom(clazz))
            return new RandomizedMap(clazz).generate();
        if( Collection.class.isAssignableFrom(clazz))
            return new RandomizedCollection(clazz).generate();
        return null;
    }
}
