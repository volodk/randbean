package org.nicebean.types;

import java.lang.reflect.Type;

import org.nicebean.explorer.JdkClassRegistry;
import org.nicebean.values.JavaBean;
import org.nicebean.values.JdkObject;
import org.nicebean.values.NullValue;

public class ValueFactory {
	
	public static AbstractValue resolve(Class<?> clazz, Type genericType){
	    
	    if(clazz != null){ // TODO: replace with another pattern matcher
	        
	        if( clazz.isPrimitive() )
	            return new org.nicebean.values.Primitive(clazz);
	        
	        if( clazz.isArray() )
                return new org.nicebean.values.Array(clazz, genericType);
	        
	        if( clazz.isEnum() ){
	            return new org.nicebean.values.Enum(clazz);
	        }
	        
	        if( JdkClassRegistry.isJdkClass(clazz) ){
	            return new JdkObject(clazz);
	        }
	        
	        return new JavaBean(clazz);
	        
	    }
		return new NullValue();
	}

}
