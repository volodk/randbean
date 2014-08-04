package org.randbean.values;

import org.randbean.explorer.Builder;
import org.randbean.explorer.Explorer;
import org.randbean.types.Randomizable;
import org.randbean.utils.Preconditions;

class RandomizedJavaBean implements Randomizable{

    private Class<?> clazz;
    
    public RandomizedJavaBean(Class<?> clazz) {
        Preconditions.notNull(clazz);
        this.clazz = clazz;
    }

    @Override
    public Object generate() {
        return Builder.newInstance( Explorer.explore(clazz) );
    }

}
