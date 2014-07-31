package org.randbean.values;

import java.util.Random;

import org.randbean.types.Randomizable;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */

public class Primitive implements Randomizable {
    
    private static final Random RND = new Random();
	private static final int MAX_INT = 100;
	
	private Class<?> clazz;

    public Primitive(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public Object generate() {
		
		if( clazz.isPrimitive() ){
			switch( clazz.toString() ){
				case "byte":
					return (byte) (RND.nextInt(Byte.MAX_VALUE) & 0xFF);
				case "short":
					return (short) (RND.nextInt(Short.MAX_VALUE) & 0xFFFF);
				case "int":
					return RND.nextInt( MAX_INT );
				case "long":
					return RND.nextLong();
				case "float":
					return RND.nextFloat();
				case "double":
					return RND.nextDouble();
				case "char":
					char ch = 0;
					do {
						ch = (char) ( 'A' + RND.nextInt('z' - 'A' + 1));
					} while( ch > 'Z' && ch < 'a' );
					
					return ch;
				case "boolean":
					return RND.nextBoolean();
			}
		} else{
			System.err.println("Is not a primitive");
		}
		return null;
	}

}
