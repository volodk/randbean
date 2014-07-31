package org.randbean.types;

import java.lang.reflect.Type;

import org.randbean.explorer.JdkClassRegistry;
import org.randbean.values.JavaBean;
import org.randbean.values.JdkObject;
import org.randbean.values.NullValue;

public class ValueFactory {
	
	public static AbstractValue resolve(Class<?> clazz, Type genericType){
	    
	    if(clazz != null){ // TODO: replace with another pattern matcher
	        
	        if( clazz.isPrimitive() )
	            return new org.randbean.values.Primitive(clazz);
	        
	        if( clazz.isArray() )
                return new org.randbean.values.Array(clazz, genericType);
	        
	        if( clazz.isEnum() ){
	            return new org.randbean.values.Enum(clazz);
	        }
	        
	        if( JdkClassRegistry.isJdkClass(clazz) ){
	            return new JdkObject(clazz);
	        }
	        
	        return new JavaBean(clazz);
	        
	    }
		return new NullValue();
	}

}
