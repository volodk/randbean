package org.nicebean.types;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Arrays;

import org.nicebean.annotations.Works;
import org.nicebean.types.ValueFactory.RandomValue;
import org.nicebean.utils.ArrayUtils;

@Works(with = {Object[].class})
public class RandomArray extends AbstractValue {
	
	private Type genericType;
	
	public RandomArray(Class<?> clazz, Type genericType) {
		super(clazz );
		this.genericType = genericType;
	}

	@Override
	public Object generate( DescribeStrategy s ) {
		
		Class<?> clazz = getTargetClass();
		
		if( clazz != null && clazz.isArray() ){
			
			int d = ArrayUtils.countArrayDimensions(clazz);
			int[] dimensions = new int[d];
			int i = d;
			while( --i >= 0 ){
				dimensions[i] = 1 + rnd.nextInt( s.getSizeLimit() );
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
			
			Object array = Array.newInstance(klass, Arrays.copyOfRange(dimensions, from, to) );
			
			for(int i = 0; i < dimensions[from]; i++){
				Object value = fill(klass, rv, dimensions, from + 1, to );
				Array.set(array, i, value);
			}
			
			return array;
			
		} else {
			
			return rv.generate( DescribeStrategy.SHALLOW );
		}
		
	}

}
