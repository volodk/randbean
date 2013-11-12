package org.nicebean.types.random;

import java.lang.reflect.Type;
import java.util.Arrays;

import org.nicebean.types.AbstractValue;
import org.nicebean.types.GenerateStrategy;
import org.nicebean.types.RandomValue;
import org.nicebean.types.GeneratorFactory;
import org.nicebean.types.ValueFactory;
import org.nicebean.utils.ArrayUtils;

public class Array extends AbstractValue {
	
	public static class G implements GeneratorFactory
	{
		public boolean checkSupport(Class<?> clazz) {
			return clazz != null && clazz.isArray();
		}
		
		public RandomValue newValueGenerator(Class<?> clazz, Type genericType){
			return new Array(clazz, genericType);
		}
	}
	
	public Array(Class<?> clazz, Type genericType) {
		super(clazz, genericType );
	}

	@Override
	public Object generate( GenerateStrategy s ) {
		
		if( clazz != null && clazz.isArray() ){
			
			int d = ArrayUtils.countArrayDimensions(clazz);
			int[] dimensions = new int[d];
			int i = d;
			while( --i >= 0 ){
				dimensions[i] = 1 + rnd.nextInt( s.getContainerSizeLimit() );
			}
			
			Class<?> componentType = ArrayUtils.getComponentType(clazz);
			
			RandomValue rv = ValueFactory.resolve(componentType, genericType);
			
			return fill( componentType, rv, dimensions, 0, d );
			
		} else {
			System.err.println("Is not an Array");
		}
		
		return null;
	}
	
	private Object fill(final Class<?> klass, final RandomValue rv, int[] dimensions, int from, int to) {
		
		if( from < to ){
			
			Object array = java.lang.reflect.Array.newInstance(klass, Arrays.copyOfRange(dimensions, from, to) );
			
			for(int i = 0; i < dimensions[from]; i++){
				Object value = fill(klass, rv, dimensions, from + 1, to );
				java.lang.reflect.Array.set(array, i, value);
			}
			
			return array;
			
		} else {
			
			return rv.generate( GenerateStrategy.SHALLOW );
		}
		
	}

}
