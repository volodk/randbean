package org.randbean.values;

import java.util.List;
import java.util.Objects;

import org.randbean.core.CreationMode;
import org.randbean.types.Randomizable;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 2:36:18 PM 

class RandomizedList implements Randomizable {

    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Objects.requireNonNull(clazz);
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
