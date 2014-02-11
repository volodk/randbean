package org.nicebean.randomized;

import java.lang.reflect.Type;
import java.util.Arrays;

import org.nicebean.types.AbstractValue;
import org.nicebean.types.RandomValue;
import org.nicebean.types.ShallowRandomValue;
import org.nicebean.types.ValueFactory;
import org.nicebean.utils.ArrayUtils;

public class Array extends AbstractValue {
	
	private static final int MAX_DIMENTION_SIZE = 5;   // TODO: make it customizable via annotation parameter

    public Array(Class<?> clazz, Type genericType) {
		super(clazz, genericType );
	}

	@Override
	protected Object doGenerate() {
		
		if( clazz.isArray() ){
			
			int d = ArrayUtils.countArrayDimensions(clazz);
			int[] dimensions = new int[d];
			int i = d;
			while( --i >= 0 ){
				dimensions[i] = 1 + rnd.nextInt(MAX_DIMENTION_SIZE);
			}
			
			Class<?> componentType = ArrayUtils.getComponentType(clazz);
			
			RandomValue rv = ValueFactory.resolve(componentType, genericType);
			
			return fill( componentType, (ShallowRandomValue) rv, dimensions, 0, d );
			
		} else {
			System.err.println("Is not an Array");
		}
		
		return null;
	}
	
	private Object fill(final Class<?> klass, final ShallowRandomValue rv, int[] dimensions, int from, int to) {
		
		if( from < to ){
			
			Object array = java.lang.reflect.Array.newInstance(klass, Arrays.copyOfRange(dimensions, from, to) );
			
			for(int i = 0; i < dimensions[from]; i++){
				Object value = fill(klass, rv, dimensions, from + 1, to );
				java.lang.reflect.Array.set(array, i, value);
			}
			
			return array;
			
		} else {
			
			return rv.generateShallow();
		}
		
	}

}
