package org.nicebean.types;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.nicebean.ArrayUtils;
import org.nicebean.types.ValueFactory.RandomValue;

public class RandomArray extends AbstractValue {
	
	public RandomArray(Class<?> clazz, boolean container) {
		super(clazz, container);
	}

	@Override
	public Object generate() {
		
		if( clazz != null && clazz.isArray() ){
			
			int MAX_LENGTH = 5;
			
			int d = ArrayUtils.countArrayDimensions(clazz);
			int[] dimensions = new int[d];
			int i = d;
			while( --i >= 0 ){
				dimensions[i] = 1 + rnd.nextInt( MAX_LENGTH - 1 );	// avoid zero-length arrays
			}
			
			Class<?> componentType = ArrayUtils.getComponentType(clazz);
			
			RandomValue rv = ValueFactory.resolve(componentType);
			
			return fill( componentType, rv, dimensions, 0, d );
			
		} else {
			System.err.println("Is not an Array");
		}
		
		return null;
	}
	
	private Object fill(final Class<?> klass, final RandomValue rv, int[] dimensions, int from, int to) {
		
		if( from < to ){
			
			Object array = Array.newInstance(klass, Arrays.copyOfRange(dimensions, from, to) );
			
			for(int i = 0; i < dimensions[from]; i++){
				Object value = fill(klass, rv, dimensions, from + 1, to );
				Array.set(array, i, value);
			}
			
			return array;
			
		} else {
			
			return rv.generate();
		}
		
	}

}
