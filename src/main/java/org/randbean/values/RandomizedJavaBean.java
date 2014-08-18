package org.randbean.values;

import org.randbean.core.Builder;
import org.randbean.core.Explorer;
import org.randbean.types.Randomizable;
import org.randbean.utils.Preconditions;
import org.randbean.utils.ReflectionUtils;

class RandomizedJavaBean implements Randomizable{

    @Override
    public Object instantiate(Class<?> clazz, boolean followReferences) {
        Preconditions.notNull(clazz);
        if ( followReferences )
            return Builder.newInstance( Explorer.explore(clazz) );
        else 
            return ReflectionUtils.newInstance(clazz);
    }

}
