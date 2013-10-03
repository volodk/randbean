package org.nicebean.datagen;

import java.lang.reflect.Array;

import org.nicebean.Utils;

public class RandomizedArray  extends AbstractRandomValue {
	
	public RandomizedArray(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Object generate() {
		if( clazz != null && clazz.isArray() ){
			
			Class<?> componentType = clazz.getComponentType();
			
//			clazz.
//			
//			int[] dimentions = Utils.countArrayDimentions(array)
//			
//			Object array = Array.newInstance(componentType, length);
//			
//			RandomizedValue rv = RandomizedValueFactory.resolve(componentType);
//			
//			for ( int i = 0; i < length; i++ ){
//				Array.set(array, i, rv.generate());
//			}
//			
//			return array;
			
		} else {
			System.err.println("Is not an Array");
		}
		return null;
	}

}
