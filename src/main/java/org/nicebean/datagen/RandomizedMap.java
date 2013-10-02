package org.nicebean.datagen;

import java.util.Map;

public class RandomizedMap  extends AbstractRandomValue {

	public RandomizedMap(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Object get() {
		if( clazz!= null && Map.class.isAssignableFrom(clazz) ){
			 
		} else{
			System.err.println("Is not a Map");
		}
		return null;
	}

}
