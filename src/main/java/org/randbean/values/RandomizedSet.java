package org.randbean.values;

import java.util.Set;

import org.randbean.core.CreationMode;
import org.randbean.types.Randomizable;
import org.randbean.utils.Preconditions;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 2:36:18 PM 

class RandomizedSet implements Randomizable {

    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Preconditions.notNull(clazz);
        
        if( clazz.equals(Set.class) ){
            
        } else if( Set.class.isAssignableFrom(clazz) ){
            
        }
        
        return null;
    }

}
