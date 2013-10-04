package org.nicebean.types;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.nicebean.Utils;
import org.nicebean.types.ValueFactory.RandomValue;

public class RandomArray  extends AbstractValue {
	
	public RandomArray(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Object generate() {
		
		if( clazz != null && clazz.isArray() ){
			
			int MAX_LENGTH = 5;
			
			int d = Utils.countArrayDimensions(clazz);
			int[] dimensions = new int[d];
			int i = d;
			while( --i >= 0 ){
				dimensions[i] = 1 + rnd.nextInt( MAX_LENGTH - 1 );	// avoid zero-length arrays
			}
			
			Class<?> componentType = getComponentType(clazz);
			
			RandomValue rv = ValueFactory.resolve(componentType);
			
			Object array = fill( componentType, rv, dimensions, 0, d );
						
			return array;
			
		} else {
			System.err.println("Is not an Array");
		}
		return null;
	}

	private Class<?> getComponentType(Class<?> clazz) {
		
		Class<?> type = clazz;
		do {
			type = type.getComponentType();
		} while( type.isArray() );
		
		return type;
	}

	private Object fill(final Class<?> klass, final RandomValue rv, int[] dimensions, int from, int to) {
		
		if( from < to ){
			
			Object array = Array.newInstance(klass, Arrays.copyOfRange(dimensions, from, to) );
			
			Object value = fill(klass, rv, dimensions, from + 1, to );
			
			for(int i = 0; i < dimensions[from]; i++){
				Array.set(array, i, value);
			}
			
			return array;
			
		} else {
			
			return rv.generate();
		}
		
	}

}
