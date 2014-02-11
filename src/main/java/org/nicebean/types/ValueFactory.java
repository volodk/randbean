package org.nicebean.types;

import java.lang.reflect.Type;

import org.nicebean.randomized.NullValue;
import org.nicebean.randomized.JavaBean;

public class ValueFactory {
	
	public static AbstractValue resolve(Class<?> clazz, Type genericType){
	    
	    if(clazz != null){ // TODO: replace with another pattern matcher
	        
	        if( clazz.isPrimitive() )
	            return new org.nicebean.randomized.Primitive(clazz);
	        
	        if( clazz.isArray() )
                return new org.nicebean.randomized.Array(clazz, genericType);
	        
	        if( String.class.equals(clazz) )
                return new org.nicebean.randomized.String(clazz);
	        
	        if( clazz.isEnum() ){
	            return new org.nicebean.randomized.Enum(clazz);
	        }
	        
	        return new JavaBean(clazz);
	        
	    }
		return new NullValue();
	}

}
