package org.nicebean.types;

import java.lang.reflect.Type;
import java.util.Collection;

public class RandomCollection extends AbstractValue {
	
	public RandomCollection(Class<?> clazz) {
		super(clazz);
	}

	public RandomCollection(Class<?> clazz, Type genericType) {
		super(clazz, genericType);
	}
	
	@Override
	public boolean canHandle(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object generate( GenerateStrategy s ) {
		
		if( clazz != null && Collection.class.isAssignableFrom(clazz) ){
			
			// get concrete collection
			// resolve actual element type
			// get randomValue generator
			
			// insert some elements
		
			
		} else{
			System.err.println("Is not a Collection");
		}
		return null;
	}

	private Class<?> getElementClassType(Class<?> clazz) {
		
//		Type type = clazz.
		
		return null;
	}

}
