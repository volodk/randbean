package org.nicebean.types;

import java.lang.reflect.Type;

import org.nicebean.explorer.JdkClassRegistry;
import org.nicebean.randomized.JavaBean;
import org.nicebean.randomized.JdkObject;
import org.nicebean.randomized.NullValue;

public class ValueFactory {
	
	public static AbstractValue resolve(Class<?> clazz, Type genericType){
	    
	    if(clazz != null){ // TODO: replace with another pattern matcher
	        
	        if( clazz.isPrimitive() )
	            return new org.nicebean.randomized.Primitive(clazz);
	        
	        if( clazz.isArray() )
                return new org.nicebean.randomized.Array(clazz, genericType);
	        
	        if( clazz.isEnum() ){
	            return new org.nicebean.randomized.Enum(clazz);
	        }
	        
	        if( JdkClassRegistry.isJdkClass(clazz) ){
	            return new JdkObject(clazz);
	        }
	        
	        return new JavaBean(clazz);
	        
	    }
		return new NullValue();
	}

}
