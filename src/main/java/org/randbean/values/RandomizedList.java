package org.randbean.values;

import java.util.List;

import org.randbean.core.CreationMode;
import org.randbean.types.Randomizable;
import org.randbean.utils.Preconditions;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 2:36:18 PM 

class RandomizedList implements Randomizable {

    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Preconditions.notNull(clazz);
        Object list = null;
        
        if( clazz.isInterface() ){
            
            if( clazz == List.class) {
                
            }
            
        } else {
            list = null;
        }
        
        return list;
    }

}
