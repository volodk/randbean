package org.nicebean.types;

import java.util.Map;

import org.nicebean.annotations.Works;

@Works( with = Map.class )
public class RandomMap extends AbstractValue {

	public RandomMap(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Object generate(Size s) {
		
		if( clazz != null && Map.class.isAssignableFrom(clazz) ){
			 
		} else{
			System.err.println("Is not a Map");
		}
		return null;
	}

}
