package org.randbean.values;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Random;

import org.randbean.types.Randomizable;
import org.randbean.types.ValueFactory;
import org.randbean.utils.ArrayUtils;

public class Array implements Randomizable {
	
    private static final Random RND = new Random();
	private static final int MAX_DIMENTION_SIZE = Integer.parseInt(System.getProperty("arrays.max.size", "5"));
	
	private Class<?> clazz;
	private Type genericType;

    public Array(Class<?> clazz, Type genericType) {
        this.clazz = clazz;
        this.genericType = genericType;
	}

	@Override
    public Object generate() {
		if( clazz.isArray() ){
			
			int d = ArrayUtils.countArrayDimensions(clazz);
			int[] dimensions = new int[d];
			int i = d;
			while( --i >= 0 ){
				dimensions[i] = 1 + RND.nextInt(MAX_DIMENTION_SIZE);
			}
			
			Class<?> componentType = ArrayUtils.getComponentType(clazz);
			
			Randomizable rv = ValueFactory.resolve(componentType, genericType);
			
			return fill(componentType, rv, dimensions, 0, d);
		} else {
			System.err.println("Is not an Array");
		}
		return null;
	}
	
	private Object fill(final Class<?> klass, final Randomizable rv, int[] dimensions, int from, int to) {
		if( from < to ){
			Object array = java.lang.reflect.Array.newInstance(klass, Arrays.copyOfRange(dimensions, from, to) );
			for(int i = 0; i < dimensions[from]; i++){
				Object value = fill(klass, rv, dimensions, from + 1, to );
				java.lang.reflect.Array.set(array, i, value);
			}
			return array;
		} else {
			return rv.generate();
		}
	}

}
