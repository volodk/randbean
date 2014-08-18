package org.randbean.types;

import org.randbean.core.CreationMode;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:31:47 PM 

public interface Randomizable {
	Object instantiate(Class<?> clazz, CreationMode creationMode);
}