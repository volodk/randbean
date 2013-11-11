package org.nicebean.types;

import java.lang.reflect.Type;
import java.util.Map;

import org.nicebean.utils.CollectionUtils;

public class RandomMap extends AbstractValue {
	
	public RandomMap(Class<?> clazz, Type genericType) {
		super(clazz, genericType);
	}
	
	@Override
	public boolean canHandle(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object generate(GenerateStrategy s) {
		
		if( clazz != null && Map.class.isAssignableFrom(clazz) ){
			
			Map<?,?> map = CollectionUtils.concreteMap();
			
			// resolve actual element type
			// get randomValue generator
			
			// insert some elements
			 
		} else{
			System.err.println("Is not a Map");
		}
		return null;
	}

}
