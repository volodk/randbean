package org.nicebean;

import java.lang.reflect.Field;

public class ReflectionUtils {
	
	public static void set(Field field, Object instance, Object value){
		boolean wrt = field.isAccessible();
		field.setAccessible(true);
		try {
			field.set(instance, value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			System.err.println("Cannot set value, details : " + e.getMessage());
		}
		field.setAccessible(wrt);
	}
	
}
