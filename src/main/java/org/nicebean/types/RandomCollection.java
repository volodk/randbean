package org.nicebean.types;

import java.util.Collection;

public class RandomCollection extends AbstractValue {

	public RandomCollection(Class<?> clazz, boolean container) {
		super(clazz, container);
	}

	@Override
	public Object generate() {
		if( clazz != null && Collection.class.isAssignableFrom(clazz) ){
			
		} else{
			System.err.println("Is not a Collection");
		}
		return null;
	}

}
