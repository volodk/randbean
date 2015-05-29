package org.randbean.values;

import org.randbean.core.CreationMode;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:31:47 PM 

public interface RandomizableValue {
	Object instantiate(Class<?> clazz, CreationMode creationMode);
}