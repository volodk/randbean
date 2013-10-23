package org.nicebean.types;

import java.lang.reflect.Type;
import java.util.Map;

import org.nicebean.annotations.Works;
import org.nicebean.utils.CollectionUtils;

@Works( with = Map.class )
public class RandomMap extends AbstractValue {

	private Type genericType;
	
	public RandomMap(Class<?> clazz, Type genericType) {
		super(clazz);
		this.genericType = genericType;
	}

	@Override
	public Object generate(DescribeStrategy s) {
		
		Class<?> clazz = getTargetClass();
		
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
