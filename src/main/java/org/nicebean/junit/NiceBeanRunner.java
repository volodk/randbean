package org.nicebean.junit;

import java.lang.annotation.Annotation;
import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.nicebean.annotations.Nice;
import org.nicebean.types.ValueFactory;
import org.nicebean.types.ValueFactory.RandomValue;
import org.nicebean.utils.BeanUtils;

public class NiceBeanRunner extends BlockJUnit4ClassRunner {

	private final List<FrameworkField> fields;
	
	public NiceBeanRunner(Class<?> clazz) throws InitializationError {

		super(clazz);
		
		fields = getTestClass().getAnnotatedFields(Nice.class);
	}
	
	@Override
	protected Statement methodInvoker(FrameworkMethod method, Object test) {
		
		populateNiceObjects(test);
		
		return super.methodInvoker(method, test);
	}

	protected void populateNiceObjects(Object test) {
		
		for (FrameworkField field : fields) {
			
			Class<?> fieldClass = field.getField().getType();
			
			RandomValue.Size depth = resolveMaxRecursiveDepth(field.getAnnotations());
			
			RandomValue rv = ValueFactory.resolve(fieldClass);
			Object value = rv.generate( depth );
			
			BeanUtils.setSilently(field.getField(), test, value);
		}
	}

	private RandomValue.Size resolveMaxRecursiveDepth(Annotation[] annotations) {
		return ( (Nice)annotations[0] ).size();
	}

}
