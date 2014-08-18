package org.randbean.values;

import org.randbean.core.Builder;
import org.randbean.core.Explorer;
import org.randbean.core.CreationMode;
import org.randbean.types.Randomizable;
import org.randbean.utils.Preconditions;
import org.randbean.utils.ReflectionUtils;

class RandomizedJavaBean implements Randomizable{

    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Preconditions.notNull(clazz);
        if ( CreationMode.DEEP == mode )
            return Builder.newInstance( Explorer.explore(clazz) );
        else 
            return ReflectionUtils.newInstance(clazz);
    }

}
