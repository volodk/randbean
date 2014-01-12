package org.nicebean.types;

import java.lang.reflect.Type;

import org.nicebean.randomized.Array;
import org.nicebean.randomized.NullValue;
import org.nicebean.randomized.Primitive;

public class ValueFactory {
	
	public static RandomValue resolve(Class<?> clazz, Type genericType){
	    if(clazz != null){
	        
	        if(clazz.isPrimitive())
	            return new Primitive(clazz);
	        
	        if(clazz.isArray())
                return new Array(clazz, genericType);
	        
	        if(String.class.equals(clazz))
                return new org.nicebean.randomized.String(clazz);
	        
	    }
		return new NullValue();
	}

}
