package org.nicebean.junit;

import java.lang.reflect.Field;

import org.nicebean.explorer.Builder;
import org.nicebean.explorer.Explorer;
import org.nicebean.explorer.Node;
import org.nicebean.utils.BeanUtils;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 1:17:32 PM 

public class NiceBean {
    
    private NiceBean() {
    }
    
    public static void init(Object test){
        Class<?> testClass = test.getClass();  
        for( Field f: testClass.getDeclaredFields() ){
            if( f.isAnnotationPresent(Nice.class) ){
                
                Node root = Explorer.buildReferenceGraph( f.getType() );
                Object value = Builder.newInstance(root);
                BeanUtils.setSilently(f, test, value);
                
            }
        }
    }
}
