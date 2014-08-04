package org.randbean.values;

import org.randbean.types.Randomizable;
import org.randbean.utils.ArrayUtils;
import org.randbean.utils.Preconditions;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:44:56 PM 

class RandomizedEnum implements Randomizable {
    
    private Class<?> clazz;

    public RandomizedEnum(Class<?> clazz) {
        Preconditions.notNull(clazz);
        Preconditions.assertThat(clazz.isEnum(), new IllegalArgumentException(
                "Unsupported classtype, class : " + clazz));
        this.clazz = clazz;
    }

    @Override
    public Object generate() {
        return ArrayUtils.randomElement(clazz.getEnumConstants());
    }
}
