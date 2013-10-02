package org.nicebean.junit;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.nicebean.Nice;
import org.nicebean.ReflectionUtils;
import org.nicebean.datagen.RandomizedPrimitive;
import org.nicebean.explorer.Explorer;
import org.nicebean.explorer.Instance;
import org.nicebean.explorer.Node;

public class NiceBeanRunner extends BlockJUnit4ClassRunner {

	private Set<Field> candidates = new LinkedHashSet<Field>();

	public NiceBeanRunner(Class<?> clazz) throws InitializationError {

		super(clazz);

		for (Field f : clazz.getDeclaredFields()) {
			if (f.isAnnotationPresent(Nice.class)) {
				candidates.add(f);
			}
		}

	}

	private void insertRandomizedValues() {
		
		Object testInstance = null;	// TODO Get a reference on test !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		for (Field field : candidates) {
			
			Object value;
			Class<?> fieldClass = field.getType();
			
			if ( fieldClass.isPrimitive() ) {
				
				RandomizedPrimitive rp = new RandomizedPrimitive(fieldClass);
				value = rp.get();
			
			} else {
				
				int max_depth = 3;
				Node root = Explorer.buildReferenceGraph(fieldClass, max_depth);
				value = Instance.newObject(root);
				
			}
			
			ReflectionUtils.set(field, testInstance, value);
		}
	}

}
