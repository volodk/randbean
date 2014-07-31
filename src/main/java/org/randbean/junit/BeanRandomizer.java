package org.randbean.junit;

import java.lang.reflect.Field;

import org.randbean.explorer.Builder;
import org.randbean.explorer.Explorer;
import org.randbean.utils.ReflectionUtils;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 1:17:32 PM 

public final class BeanRandomizer {
    
    private BeanRandomizer() {
    }
    
    public static void init(Object testInstance){
        for( Field field: testInstance.getClass().getDeclaredFields() ){
            if( field.isAnnotationPresent(Randomize.class) ){
                Object generatedValue = Builder.newInstance( Explorer.explore( field.getType() ));
                ReflectionUtils.set(testInstance, field, generatedValue);
            }
        }
    }
}
