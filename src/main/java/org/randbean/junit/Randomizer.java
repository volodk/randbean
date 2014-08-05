package org.randbean.junit;

import java.lang.reflect.Field;

import org.randbean.explorer.Builder;
import org.randbean.explorer.Explorer;
import org.randbean.utils.ReflectionUtils;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 1:17:32 PM 

public final class Randomizer {
    
    private Randomizer() {
    }
    
    public static void populate(Object obj){
        if( obj != null )
            for( Field field: obj.getClass().getDeclaredFields() ){
                if( field.isAnnotationPresent(Randomize.class) ){
                    Object generatedValue = Builder.newInstance(Explorer.explore(field));
                    ReflectionUtils.set(obj, field, generatedValue);
                }
            }
    }
}
