package org.nicebean.types;

import java.util.Date;

public class RandomDate extends AbstractValue {

	public RandomDate(Class<?> clazz, boolean container) {
		super(clazz, container);
	}

	@Override
	public Object generate() {
		if( clazz != null && Date.class.isAssignableFrom(clazz) ){
			try {
				return clazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				System.err.println("Cannot instantiate 'Date' instance, datails :" + e.getMessage());
			}
		} else{
			System.err.println("Is not a Date");
		}
		return null;
	}

}
