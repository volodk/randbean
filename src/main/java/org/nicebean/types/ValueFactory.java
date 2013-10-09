package org.nicebean.types;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ValueFactory {
	
	public interface RandomValue {
		enum Size {
			SHALLOW(1), DEEP(10);
			
			int depth;
			private Size(int d){
				depth = d;
			}
			public int value(){
				return depth;
			}
		}
		Object generate(Size d);
	}
	
	private static final Map<Class<?>, RandomValue> factories = new HashMap<>();
	
	static {	// TODO more declarative way, use annotations on a concrete factory
		factories.put(String.class, new RandomString(String.class));
		factories.put(Date.class, new RandomDate(Date.class));
		factories.put(java.sql.Date.class, new RandomDate(java.sql.Date.class));
	}
	
	private static final RandomValue NULL_OBJECT_VALUE = new RandomValue(){
		@Override
		public Object generate(Size d) {
			return null;
		}
	};
	
	public static RandomValue resolve(Class<?> clazz){
		
		RandomValue rv = NULL_OBJECT_VALUE;
		
		if( clazz != null ){
			
			// if is interface
			
			if ( clazz.isArray() ){
				rv = new RandomArray(clazz);
				
			} else if(clazz.isPrimitive()){
				rv = new RandomPrimitive(clazz);
				
			} else if(Collection.class.isAssignableFrom(clazz)){
				rv = new RandomCollection(clazz);
				
			} else if(Map.class.isAssignableFrom(clazz)){
				rv = new RandomMap(clazz);
				
			} else if(factories.containsKey(clazz)){
				rv = factories.get(clazz);
				
			} else {
				rv = new RandomPlainBean(clazz);
			}
		}
		
		return rv;
	}
}
