package org.nicebean.types.random;

import java.lang.reflect.Type;

import org.nicebean.explorer.Builder;
import org.nicebean.explorer.Explorer;
import org.nicebean.explorer.JdkClassRegistry;
import org.nicebean.explorer.Node;
import org.nicebean.types.AbstractValue;
import org.nicebean.types.GenerateStrategy;
import org.nicebean.types.RandomValue;
import org.nicebean.types.GeneratorFactory;

public class PlainBean extends AbstractValue {
	
	public static class G implements GeneratorFactory
	{
		public boolean checkSupport(Class<?> clazz) {
			return !JdkClassRegistry.isJdkClass(clazz);
		}
		
		public RandomValue newValueGenerator(Class<?> clazz, Type genericType){
			return new PlainBean(clazz);
		}
	}

	PlainBean(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Object generate(GenerateStrategy gs) {
		
		Node root = Explorer.buildReferenceGraph(clazz, gs);
		
		return Builder.newInstance(root);
	}
}
