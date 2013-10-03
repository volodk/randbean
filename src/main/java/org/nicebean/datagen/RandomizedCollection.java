package org.nicebean.datagen;

import java.util.Collection;

public class RandomizedCollection extends AbstractRandomValue {

	public RandomizedCollection(Class<?> clazz) {
		super(clazz);
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
