package org.randbean.utils;

import java.util.Random;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */
public class ArrayUtils {
    
    private static final Random rnd = new Random();
    
    public static <E> E randomElement(E[] array){
        if( array != null && array.length > 1){
            int L = array.length;
            return array[ rnd.nextInt(L)]; 
        }
        return null;
    }
	
	public static int countArrayDimensions( Class<?> arrayClazz ){
		if( arrayClazz.isArray() ){
			int d = 0;
			for( char ch : arrayClazz.toString().toCharArray() ){
				d += (ch == '[') ? 1 : 0;
			}
			return d;
		} else {
			throw new IllegalArgumentException("Not an array, class :" + arrayClazz); 
		}
	}
	
	public static int[] countArrayDimensions( Object array ) {
		String msg;
		if ( array != null){
			if( array.getClass().isArray() ){
				return null;
			} else {
				msg = "Not an array";
			}
		}  else{
			msg = "Object is NULL";
		}
		throw new IllegalArgumentException(msg);
	}
	
	public static Class<?> getArrayClass(Class<?> component, int dimensions) throws ClassNotFoundException{
		return getArrayClass(ArrayUtils.class.getClassLoader(), component, dimensions);
	}
	
	public static Class<?> getArrayClass(ClassLoader loader, Class<?> component, int dimensions) throws ClassNotFoundException{
		String str = component.getName();
		while( dimensions -- > 0 ){
			str += "[]";
		}
		str += ".class";
		return loader.loadClass(str);
	}
	
	public static Class<?> getComponentType(Class<?> arrayClazz) {
		if( arrayClazz != null && arrayClazz.isArray() ){
			Class<?> type = arrayClazz;
			do {
				type = type.getComponentType();
			} while( type.isArray() );
			return type;
		}
		return null;
	}
	
}
