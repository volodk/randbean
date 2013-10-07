package org.nicebean.types;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ValueFactory {
	
	public interface RandomValue {
		Object generate();
		boolean isComplex();
	}
	
	private static final Map<Class<?>, RandomValue> factories = new HashMap<>();
	
	static {
		factories.put(String.class, new RandomString(String.class, false));
		factories.put(Date.class, new RandomDate(Date.class, false));
		factories.put(java.sql.Date.class, new RandomDate(java.sql.Date.class, false));
	}
	
	private static final RandomValue NULL_OBJECT_VALUE = new RandomValue(){
		@Override
		public Object generate() {
			return null;
		}
		@Override
		public boolean isComplex() {
			return false;
		}
	};
	
	public static RandomValue resolve(Class<?> clazz){
		
		RandomValue rv = NULL_OBJECT_VALUE;
		
		if( clazz != null ){

			if ( clazz.isArray() ){
				rv = new RandomArray(clazz, true);
				
			} else if(clazz.isPrimitive()){
				rv = new RandomPrimitive(clazz, false);
				
			} else if(Collection.class.isAssignableFrom(clazz)){
				rv = new RandomCollection(clazz, true);
				
			} else if(Map.class.isAssignableFrom(clazz)){
				rv = new RandomMap(clazz, true);
				
			} else if(factories.containsKey(clazz)){
				rv = factories.get(clazz);
				
			} else{
				rv = new Bean(clazz, true);
			}
		}
		
		return rv;
	}
}
