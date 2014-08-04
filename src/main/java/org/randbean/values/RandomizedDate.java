package org.randbean.values;

import org.randbean.types.Randomizable;
import org.randbean.utils.Preconditions;

class RandomizedDate implements Randomizable {

    private Class<?> clazz;

    public RandomizedDate(Class<?> clazz) {
        Preconditions.notNull(clazz);
        Preconditions.assertThat(clazz.isAssignableFrom(java.util.Date.class), new IllegalArgumentException(
                "Unsupported classtype, class : " + clazz));
        this.clazz = clazz;
    }

    @Override
    public Object generate() {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
