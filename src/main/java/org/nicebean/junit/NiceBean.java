package org.nicebean.junit;

import java.lang.reflect.Field;

import org.nicebean.explorer.Builder;
import org.nicebean.explorer.Explorer;
import org.nicebean.explorer.Structure;
import org.nicebean.utils.ReflectionUtils;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 1:17:32 PM 

public final class NiceBean {
    
    private NiceBean() {
    }
    
    public static void init(Object testInstance){
        for( Field f: testInstance.getClass().getDeclaredFields() ){
            if( f.isAnnotationPresent(Nice.class) ){
                Structure root = Explorer.structureOf( f.getType() );
                Object value = Builder.newInstance(root);
                ReflectionUtils.set(testInstance, f, value);
            }
        }
    }
}
