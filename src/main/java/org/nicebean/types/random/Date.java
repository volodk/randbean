package org.nicebean.types.random;

import java.lang.reflect.Type;

import org.nicebean.types.AbstractValue;
import org.nicebean.types.GenerateStrategy;
import org.nicebean.types.RandomValue;
import org.nicebean.types.GeneratorFactory;

public class Date extends AbstractValue {
	
	public static class G implements GeneratorFactory
	{
		public boolean checkSupport(Class<?> clazz) {
			return java.util.Date.class.isAssignableFrom(clazz);
		}
		
		public RandomValue newValueGenerator(Class<?> clazz, Type genericType){
			return new Date(clazz);
		}
	}

	Date(Class<?> clazz) {
		super(clazz);
	}
	
	@Override
	public Object generate( /*ignore*/ GenerateStrategy gs ) {
		
		if( clazz != null && java.util.Date.class.isAssignableFrom(clazz) ){
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
