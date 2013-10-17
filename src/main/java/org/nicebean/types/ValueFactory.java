package org.nicebean.types;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ValueFactory {
	
	public interface RandomValue {
		
		enum DetailLevel {
			
			SHALLOW(1) {
				@Override
				public boolean followReferences() {
					return false;
				}
			}, FULL(10) {
				@Override
				public boolean followReferences() {
					return true;
				}
			};
			
			private int depth;
			
			private DetailLevel(int d){
				depth = d;
			}
			
			public int value(){
				return depth;
			}
			
			public abstract boolean followReferences();
		}
		
		Object generate(DetailLevel d);
	}
	
	private static final Map<Class<?>, RandomValue> factories = new HashMap<>();
	
	static {	// TODO more declarative way, use annotations on a concrete factory
		factories.put(String.class, new RandomString(String.class));
		factories.put(Date.class, new RandomDate(Date.class));
		factories.put(java.sql.Date.class, new RandomDate(java.sql.Date.class));
	}
	
	private static final RandomValue NULL_OBJECT_VALUE = new RandomValue(){
		@Override
		public Object generate(DetailLevel d) {
			return null;
		}
	};
	
	public static RandomValue resolve(Class<?> clazz, Type genericType){
		
		RandomValue rv = NULL_OBJECT_VALUE;
		
		if( clazz != null ){
			
			// TODO: if is interface
			
			if(clazz.isPrimitive()){
				rv = new RandomPrimitive(clazz);
				
			} else if ( clazz.isArray() ){
				rv = new RandomArray(clazz, genericType);
				
			} else if (Collection.class.isAssignableFrom(clazz)){
				rv = new RandomCollection(clazz, genericType);
				
			} else if (Map.class.isAssignableFrom(clazz)){
				rv = new RandomMap(clazz, genericType);
				
			} else if (factories.containsKey(clazz)){
				rv = factories.get(clazz);
				
			} else {
				rv = new RandomPlainBean(clazz);
			}
		}
		
		return rv;
	}

}
