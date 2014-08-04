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
        Randomizable value = new NullValue();

        if (String.class.equals(clazz)) {
            value = new RandomizedString();

        } else if (Date.class.isAssignableFrom(clazz)) {
            value = new RandomizedDate(clazz);

        } else if (Map.class.isAssignableFrom(clazz)) {
            value = new RandomizedMap(clazz);

        } else if (Collection.class.isAssignableFrom(clazz)) {
            value = new RandomizedCollection(clazz);

        }
        return value.generate();
    }
}
