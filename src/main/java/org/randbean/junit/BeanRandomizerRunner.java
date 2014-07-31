package org.randbean.junit;

import java.lang.reflect.Field;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.randbean.explorer.Builder;
import org.randbean.explorer.ClassStructure;
import org.randbean.explorer.Explorer;
import org.randbean.utils.ReflectionUtils;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */
public class BeanRandomizerRunner extends BlockJUnit4ClassRunner {
	
	public BeanRandomizerRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
	protected Statement methodInvoker(FrameworkMethod method, Object test) {
		populate(test);
		return super.methodInvoker(method, test);
	}

	protected void populate(final Object testInstance) {
		for (FrameworkField f : getTestClass().getAnnotatedFields(Randomize.class) ) {
			Field field = f.getField();
			Class<?> classType = field.getType();
			ClassStructure root = Explorer.explore(classType);
			Object value = Builder.newInstance(root);
			ReflectionUtils.set(testInstance, field, value);
		}
	}

}
