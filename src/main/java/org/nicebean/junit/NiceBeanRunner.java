package org.nicebean.junit;

import java.lang.annotation.Annotation;
import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.nicebean.Nice;
import org.nicebean.Utils;
import org.nicebean.explorer.Explorer;
import org.nicebean.explorer.Instance;
import org.nicebean.explorer.Node;

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
			
			Object value;
			Class<?> fieldClass = field.getField().getType();
			
			int maxDepth = resolveMaxRecursiveDepth(field.getAnnotations());
			
			Node root = Explorer.buildReferenceGraph(fieldClass, maxDepth);
			value = Instance.newObject(root);
			
			Utils.setSilently(field.getField(), test, value);
		}
	}

	private int resolveMaxRecursiveDepth(Annotation[] annotations) {
		return ( (Nice)annotations[0] ).recursiveDepth();
	}

}
