package org.nicebean.randomized;

import org.nicebean.types.AbstractValue;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */

public class Primitive extends AbstractValue {

	private static final int MAX_INT = 100;

    public Primitive(Class<?> clazz) {
		super(clazz);
	}
	
	@Override
	protected Object doGenerate() {
		
		if( clazz.isPrimitive() ){
			switch( clazz.toString() ){
				case "byte":
					return (byte) (rnd.nextInt(Byte.MAX_VALUE) & 0xFF);
				case "short":
					return (short) (rnd.nextInt(Short.MAX_VALUE) & 0xFFFF);
				case "int":
					return rnd.nextInt( MAX_INT );
				case "long":
					return rnd.nextLong();
				case "float":
					return rnd.nextFloat();
				case "double":
					return rnd.nextDouble();
				case "char":
					char ch = 0;
					do {
						ch = (char) ( 'A' + rnd.nextInt('z' - 'A' + 1));
					} while( ch > 'Z' && ch < 'a' );
					
					return ch;
				case "boolean":
					return rnd.nextBoolean();
			}
		} else{
			System.err.println("Is not a primitive");
		}
		return null;
	}

}
