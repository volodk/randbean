package org.nicebean.junit;

import java.lang.reflect.Field;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.nicebean.explorer.Builder;
import org.nicebean.explorer.Explorer;
import org.nicebean.explorer.Structure;
import org.nicebean.utils.ReflectionUtils;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */
public class NiceBeanRunner extends BlockJUnit4ClassRunner {
	
	public NiceBeanRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
	protected Statement methodInvoker(FrameworkMethod method, Object test) {
		populate(test);
		return super.methodInvoker(method, test);
	}

	protected void populate(final Object testInstance) {
		for (FrameworkField f : getTestClass().getAnnotatedFields(Nice.class) ) {
			Field field = f.getField();
			Class<?> classType = field.getType();
			Structure root = Explorer.structureOf(classType);
			Object value = Builder.newInstance(root);
			ReflectionUtils.set(testInstance, field, value);
		}
	}

}
