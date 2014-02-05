package org.nicebean.randomized;

import org.nicebean.types.AbstractValue;

public class Date extends AbstractValue {

	Date(Class<?> clazz) {
		super(clazz);
	}
	
	@Override
	protected Object doGenerate() {
		
		if( java.util.Date.class.isAssignableFrom(clazz) ){
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
