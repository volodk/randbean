package org.nicebean.junit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.nicebean.annotations.Nice;
import org.nicebean.types.DescribeStrategy;
import org.nicebean.types.ValueFactory;
import org.nicebean.types.ValueFactory.RandomValue;
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
			
			Field fieldObject = ff.getField();
			Class<?> fieldClass = fieldObject.getType();
			
			RandomValue rv = ValueFactory.resolve(fieldClass, fieldObject.getGenericType() );
			
			DescribeStrategy descr = resolveStrategy(ff.getAnnotations());
			
			Object value = rv.generate( descr );
			
			BeanUtils.setSilently(fieldObject, test, value);
		}
	}

	private DescribeStrategy resolveStrategy(Annotation[] annotations) {
		return ( (Nice)annotations[0] ).description();
	}

}
