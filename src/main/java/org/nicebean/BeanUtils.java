package org.nicebean;

import java.lang.reflect.Field;

public class BeanUtils {
	
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
	
	public static Object newInstance( Class<?> clazz ) throws InstantiationException, IllegalAccessException{
		return clazz.newInstance();
	}
	
}
