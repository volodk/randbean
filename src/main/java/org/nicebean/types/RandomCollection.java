package org.nicebean.types;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.nicebean.annotations.Works;

@Works(with = {Collection.class, List.class, Set.class})
public class RandomCollection extends AbstractValue {
	
	private Type genericType;

	public RandomCollection(Class<?> clazz, Type genericType) {
		super(clazz);
		this.genericType = genericType;
	}

	@Override
	public Object generate( DetailLevel s ) {
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
