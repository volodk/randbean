package org.nicebean.types.random;

import java.lang.reflect.Type;

import org.nicebean.types.AbstractValue;
import org.nicebean.types.GenerateStrategy;
import org.nicebean.types.RandomValue;
import org.nicebean.types.GeneratorFactory;
import org.nicebean.utils.CollectionUtils;
import org.nicebean.utils.ReflectionTypeUtils;

public class Collection extends AbstractValue {
	
	public static class G implements GeneratorFactory
	{
		public boolean checkSupport(Class<?> clazz) {
			return java.util.Collection.class.isAssignableFrom(clazz);
		}
		
		public RandomValue newValueGenerator(Class<?> clazz, Type genericType){
			return new Collection(clazz, genericType);
		}
	}

	public Collection(Class<?> clazz, Type genericType) {
		super(clazz, genericType);
	}
		

	@Override
	public Object generate( GenerateStrategy gs ) {
		
		java.util.Collection coll = null;
		
		if( clazz != null && java.util.Collection.class.isAssignableFrom(clazz) ){
			
			coll = CollectionUtils.getConcreteCollectionByClass(clazz);
			if ( coll != null ) {
				Class<?> elementClassType = ReflectionTypeUtils.resolveElementClassType(genericType);
				
				for(int count = 0; count < gs.getContainerSizeLimit(); count++){
					Object elem = null;
					coll.add(elem);
				}
				
			} else {
				
			}
			
		} else{
			System.err.println("Is not a Collection");
		}
		
		return coll;
	}

	private Class<?> getElementClassType(Class<?> clazz) {
		
//		Type type = clazz.
		
		return null;
	}

}
