package org.nicebean.types;

import java.lang.reflect.Type;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:31:47 PM 

public interface GeneratorFactory {
	
	boolean checkSupport(Class<?> clazz);
	
	RandomValue newValueGenerator(Class<?> clazz, Type genericType);
}