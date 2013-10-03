package org.nicebean.datagen;

import java.util.Date;

public class RandomizedDate extends AbstractRandomValue {

	public RandomizedDate(Class<?> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object generate() {
		if( clazz!= null && Date.class.isAssignableFrom(clazz) ){
			return new Date();
		} else{
			System.err.println("Is not a Date");
		}
		return null;
	}

}
