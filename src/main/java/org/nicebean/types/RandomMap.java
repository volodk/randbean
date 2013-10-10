package org.nicebean.types;

import java.lang.reflect.Type;
import java.util.Map;

import org.nicebean.annotations.Works;

@Works( with = Map.class )
public class RandomMap extends AbstractValue {

	private Type genericType;
	
	public RandomMap(Class<?> clazz, Type genericType) {
		super(clazz);
		this.genericType = genericType;
	}

	@Override
	public Object generate(DetailLevel s) {
		
		if( clazz != null && Map.class.isAssignableFrom(clazz) ){
			 
		} else{
			System.err.println("Is not a Map");
		}
		return null;
	}

}
