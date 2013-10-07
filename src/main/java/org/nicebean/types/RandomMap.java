package org.nicebean.types;

import java.util.Map;

public class RandomMap  extends AbstractValue {

	public RandomMap(Class<?> clazz, boolean container) {
		super(clazz, container);
	}

	@Override
	public Object generate() {
		if( clazz != null && Map.class.isAssignableFrom(clazz) ){
			 
		} else{
			System.err.println("Is not a Map");
		}
		return null;
	}

}
