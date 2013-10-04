package org.nicebean.types;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValueFactory {
	
	public interface RandomValue {
		Object generate();
	}
	
	private static final Map<Class<?>, RandomValue> factories = new HashMap<>();
	
	static {
		factories.put(String.class, new RandomString(String.class));
		factories.put(Date.class, new RandomDate(Date.class));
		
		factories.put(boolean.class, new RandomPrimitive(boolean.class));
		factories.put(byte.class, new RandomPrimitive(byte.class));
		factories.put(short.class, new RandomPrimitive(short.class));
		factories.put(char.class, new RandomPrimitive(char.class));
		factories.put(int.class, new RandomPrimitive(int.class));
		factories.put(long.class, new RandomPrimitive(long.class));
		factories.put(float.class, new RandomPrimitive(float.class));
		factories.put(double.class, new RandomPrimitive(double.class));
		
		factories.put(boolean[].class, new RandomArray(boolean[].class));
		factories.put(byte[].class, new RandomArray(byte[].class));
		factories.put(short[].class, new RandomArray(short[].class));
		factories.put(char[].class, new RandomArray(char[].class));
		factories.put(int[].class, new RandomArray(int[].class));
		factories.put(long[].class, new RandomArray(long[].class));
		factories.put(float[].class, new RandomArray(float[].class));
		factories.put(double[].class, new RandomArray(double[].class));
		
		factories.put(boolean[][].class, new RandomArray(boolean[][].class));
		factories.put(byte[][].class, new RandomArray(byte[][].class));
		factories.put(short[][].class, new RandomArray(short[][].class));
		factories.put(char[][].class, new RandomArray(char[][].class));
		factories.put(int[][].class, new RandomArray(int[][].class));
		factories.put(long[][].class, new RandomArray(long[][].class));
		factories.put(float[][].class, new RandomArray(float[][].class));
		factories.put(double[][].class, new RandomArray(double[][].class));
		
		factories.put(boolean[][][].class, new RandomArray(boolean[][][].class));
		factories.put(byte[][][].class, new RandomArray(byte[][][].class));
		factories.put(short[][][].class, new RandomArray(short[][][].class));
		factories.put(char[][][].class, new RandomArray(char[][][].class));
		factories.put(int[][][].class, new RandomArray(int[][][].class));
		factories.put(long[][][].class, new RandomArray(long[][][].class));
		factories.put(float[][][].class, new RandomArray(float[][][].class));
		factories.put(double[][][].class, new RandomArray(double[][][].class));
		
		
		factories.put(Collection.class, new RandomCollection(Collection.class));
		factories.put(List.class, new RandomCollection(List.class));
		factories.put(Set.class, new RandomCollection(Set.class));
		
		factories.put(Map.class, new RandomMap(Map.class));
	}
	
	private static final RandomValue NULL_OBJECT_VALUE = new RandomValue(){
		@Override
		public Object generate() {
			return null;
		}
	};
	
	public static RandomValue resolve(Class<?> clazz){
		if(factories.containsKey(clazz)){
			return factories.get(clazz);
		} else {
			return NULL_OBJECT_VALUE;
		}
	}
}
