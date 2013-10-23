package org.nicebean.types;

import org.nicebean.annotations.Works;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */

@Works(with = { boolean.class, byte.class, short.class, char.class, int.class,
		long.class, float.class, double.class })
public class RandomPrimitive extends AbstractValue {

	public RandomPrimitive(Class<?> clazz) {
		super(clazz);
	}
	
	@Override
	public Object generate( DescribeStrategy s) {
		
		Class<?> clazz = getTargetClass();
		
		if( clazz!= null && clazz.isPrimitive() ){
			switch( clazz.toString() ){
				case "byte":
					return (byte) (rnd.nextInt(Byte.MAX_VALUE) & 0xFF);
				case "short":
					return (short) (rnd.nextInt(Short.MAX_VALUE) & 0xFFFF);
				case "int":
					return rnd.nextInt( s.getIntegerLimit() );
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
