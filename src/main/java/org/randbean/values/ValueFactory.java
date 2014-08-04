package org.randbean.values;

import org.randbean.explorer.ClassNode;
import org.randbean.explorer.JdkClasses;
import org.randbean.types.Randomizable;

public class ValueFactory {
    
    public static Randomizable resolve(ClassNode s){
        return resolve(s.getClassType());
    }
	
    public static Randomizable resolve(Class<?> clazz){
	    if( clazz != null ){
	        if( clazz.isPrimitive() ){
	            return new org.randbean.values.PrimitiveValue(clazz);
	        } else if( clazz.isArray() ){
                return new org.randbean.values.RandomizedArray(clazz);
	        } else if( clazz.isEnum() ){
	            return new org.randbean.values.RandomizedEnum(clazz);
	        } else if( clazz.isInterface() ){
                return new ProxiedObject(clazz);
            } else if( JdkClasses.isKnown(clazz) ){
	            return new RandomizedJdkObject(clazz);
	        } else 
	            return new RandomizedJavaBean(clazz);
	    }
		return new NullValue();
	}

}