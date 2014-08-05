package org.randbean.junit;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */
public class RandomizeRunner extends BlockJUnit4ClassRunner {
	
	public RandomizeRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

    @Override
	protected Statement methodInvoker(FrameworkMethod method, Object test) {
        Randomizer.populate(test);
		return super.methodInvoker(method, test);
	}

}
