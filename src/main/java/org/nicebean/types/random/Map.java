package org.nicebean.types.random;

import java.lang.reflect.Type;

import org.nicebean.types.AbstractValue;
import org.nicebean.types.GenerateStrategy;
import org.nicebean.types.RandomValue;
import org.nicebean.types.GeneratorFactory;
import org.nicebean.utils.CollectionUtils;

public class Map extends AbstractValue {
	
	public static class G implements GeneratorFactory
	{
		public boolean checkSupport(Class<?> clazz) {
			return java.util.Map.class.isAssignableFrom(clazz);
		}
		
		public RandomValue newValueGenerator(Class<?> clazz, Type genericType){
			return new Map(clazz, genericType);
		}
	}
	
	Map(Class<?> clazz, Type genericType) {
		super(clazz, genericType);
	}
	
	@Override
	public Object generate(GenerateStrategy s) {
		
		if( clazz != null && Map.class.isAssignableFrom(clazz) ){
			
//			java.util.Map<?,?> map = CollectionUtils.concreteMap();
			
			// resolve actual element type
			// get randomValue generator
			
			// insert some elements
			 
		} else{
			System.err.println("Is not a Map");
		}
		return null;
	}

}
