package org.nicebean.types;

import java.lang.reflect.Type;

import org.nicebean.randomized.NullValue;

public class ValueFactory {
	
	public static RandomValue resolve(Class<?> clazz, Type genericType){
	    
	    if(clazz != null){ // TODO: replace with another pattern matcher
	        
	        if(clazz.isPrimitive())
	            return new org.nicebean.randomized.Primitive(clazz);
	        
	        if(clazz.isArray())
                return new org.nicebean.randomized.Array(clazz, genericType);
	        
	        if(String.class.equals(clazz))
                return new org.nicebean.randomized.String(clazz);
	        
	        if( clazz.isEnum() ){
	            return new org.nicebean.randomized.Enum(clazz);
	        }
	        
	        // TODO: add container support
//	        if(!JdkClassRegistry.isJdkClass(clazz))
//	            return new PlainBean(clazz);
	        
	    }
		return new NullValue();
	}

}
