package org.nicebean;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Utils {
	
	public static void setSilently(Field field, Object instance, Object value){
		boolean wflag = field.isAccessible();
		field.setAccessible(true);
		try {
			field.set(instance, value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			System.err.println("Cannot set value, details : " + e.getMessage());
		}
		field.setAccessible(wflag);
	}
	
	public static int[] countArrayDimentions( Object array ){
		List<Integer> spaces = new ArrayList<>();
		countArrayDimentions(array, spaces);

		int[] dimms = new int [ spaces.size() ];
		int i = 0;
		for( Integer d : spaces ){
			dimms[i++] = d;
		}
		return dimms;
	}
	
	private static void countArrayDimentions( Object array, List<Integer> spaces ){
		if( array != null ){
			try{
				int dimm = Array.getLength(array);
				if( dimm > 0 ){
					spaces.add(dimm);
					countArrayDimentions( Array.get(array, 0), spaces );
				}
			} catch( IllegalArgumentException e ) {
				// back from recursive call
			}
		}
	}
	
	
	
}
