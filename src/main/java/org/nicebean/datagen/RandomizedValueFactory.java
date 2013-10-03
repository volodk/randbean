package org.nicebean.datagen;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RandomizedValueFactory {
	
	private static final Map<Class<?>, RandomizedValue> factories = new HashMap<>();
	
	static {
		factories.put(String.class, new RandomizedString(String.class));
		factories.put(Date.class, new RandomizedDate(Date.class));
		
		factories.put(boolean.class, new RandomizedPrimitive(boolean.class));
		factories.put(byte.class, new RandomizedPrimitive(byte.class));
		factories.put(short.class, new RandomizedPrimitive(short.class));
		factories.put(char.class, new RandomizedPrimitive(char.class));
		factories.put(int.class, new RandomizedPrimitive(int.class));
		factories.put(long.class, new RandomizedPrimitive(long.class));
		factories.put(float.class, new RandomizedPrimitive(float.class));
		factories.put(double.class, new RandomizedPrimitive(double.class));
		
		factories.put(boolean[].class, new RandomizedArray(boolean[].class));
		factories.put(byte[].class, new RandomizedArray(byte[].class));
		factories.put(short[].class, new RandomizedArray(short[].class));
		factories.put(char[].class, new RandomizedArray(char[].class));
		factories.put(int[].class, new RandomizedArray(int[].class));
		factories.put(long[].class, new RandomizedArray(long[].class));
		factories.put(float[].class, new RandomizedArray(float[].class));
		factories.put(double[].class, new RandomizedArray(double[].class));
		
		
		factories.put(Collection.class, new RandomizedCollection(Collection.class));
		factories.put(List.class, new RandomizedCollection(List.class));
		factories.put(Set.class, new RandomizedCollection(Set.class));
		
		factories.put(Map.class, new RandomizedMap(Map.class));
	}
	
	private static final RandomizedValue NULL_OBJECT_VALUE = new RandomizedValue(){
		@Override
		public Object generate() {
			return null;
		}
	};
	
	public static RandomizedValue resolve(Class<?> clazz){
		if(factories.containsKey(clazz)){
			return factories.get(clazz);
		} else {
			return NULL_OBJECT_VALUE;
		}
	}
}
