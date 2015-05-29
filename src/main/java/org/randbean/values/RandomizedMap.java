package org.randbean.values;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.SortedMap;

import org.randbean.core.CreationMode;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 2:36:05 PM 

class RandomizedMap implements RandomizableValue {

    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Objects.requireNonNull(clazz);
        
        Object map = null;
        
        if( clazz.isInterface() ){
            
            if( clazz == Map.class) {
                
            }
            
            if( clazz == SortedMap.class ){
                
            }
            
            if( clazz == NavigableMap.class ){
                
            }
            
        } else {
            map = null;
        }
        
        return map;
    }

}
