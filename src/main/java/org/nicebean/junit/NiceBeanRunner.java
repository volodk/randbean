package org.nicebean.junit;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.nicebean.explorer.Builder;
import org.nicebean.explorer.Explorer;
import org.nicebean.explorer.Node;
import org.nicebean.types.RandomValue;
import org.nicebean.types.ValueFactory;
import org.nicebean.utils.BeanUtils;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */
public class NiceBeanRunner extends BlockJUnit4ClassRunner {

	private final List<FrameworkField> fields;
	
	public NiceBeanRunner(Class<?> clazz) throws InitializationError {

		super(clazz);
		
		fields = getTestClass().getAnnotatedFields(Nice.class);
	}
	
	@Override
	protected Statement methodInvoker(FrameworkMethod method, Object test) {
		
		populate(test);
		
		return super.methodInvoker(method, test);
	}

	protected void populate(final Object test) {
		
		for (FrameworkField ff : fields) {
			
			Field field = ff.getField();
			Class<?> fieldClass = field.getType();
			
			Node root = Explorer.buildReferenceGraph(fieldClass);
	        
			Object value = Builder.newInstance(root);
			
			BeanUtils.setSilently(field, test, value);
		}
	}

}
