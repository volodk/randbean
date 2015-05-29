package org.randbean.junit;

import java.lang.reflect.Field;

import org.randbean.core.Builder;
import org.randbean.core.Model;
import org.randbean.core.Explorer;
import org.randbean.utils.ReflectionUtils;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 1:17:32 PM 

public final class Randomizer {
    
    private Randomizer() {
    }
    
    public static final void populate(Object obj){

    	if( obj == null )
        	return;
        
        for( Field field: obj.getClass().getDeclaredFields() ){
            if( field.isAnnotationPresent(Randomize.class) ){
                Model model = Explorer.explore(field);
                Object generatedValue = Builder.newInstance(model);
                ReflectionUtils.set(obj, field, generatedValue);
            }
        }
    }
}
