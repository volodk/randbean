package org.nicebean;

import java.lang.reflect.Field;

public class Utils {
	
	public static void setSilently(Field field, Object instance, Object value){
		boolean wflag = field.isAccessible();
		field.setAccessible(true);
		try {
			field.set(instance, value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			System.err.println("Cannot set value, details : " + e.getMessage());
		}
		field.setAccessible(wflag);
	}
	
	public static int countArrayDimensions( Class<?> clazz ){
		if( clazz.isArray() ){
			int d = 0;
			for( char ch : clazz.toString().toCharArray() ){
				d += (ch == '[') ? 1 : 0;
			}
			return d;
		} else {
			throw new IllegalArgumentException("Not an array, class :" + clazz); 
		}
	}
}
