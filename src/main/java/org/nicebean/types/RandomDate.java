package org.nicebean.types;

import java.util.Date;

import org.nicebean.annotations.Works;

@Works( with = { Date.class, java.sql.Date.class })
public class RandomDate extends AbstractValue {

	public RandomDate(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Object generate( /*ignore*/ DescribeStrategy s ) {
		
		Class<?> clazz = getTargetClass();
		
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
