package org.randbean.values;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

import org.randbean.core.CreationMode;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 2:36:18 PM 

class RandomizedSet implements RandomizableValue {

    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Objects.requireNonNull(clazz);
        
        Object set = null;
        
        if( clazz.isInterface() ){
            
            if( clazz == Set.class) {
                
            }
            
            if( clazz == SortedSet.class ){
                
            }
            
            if( clazz == NavigableSet.class ){
                
            }
            
        } else {
            set = null;
        }
        
        return set;
    }
    
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        
        System.out.println( set.getClass().getName() );
        System.out.println( set.getClass().getTypeParameters()[0].getName() );
        
    }

}
