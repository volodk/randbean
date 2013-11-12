package org.nicebean.types.random;

import java.lang.reflect.Type;

import org.nicebean.types.AbstractValue;
import org.nicebean.types.GenerateStrategy;
import org.nicebean.types.RandomValue;
import org.nicebean.types.GeneratorFactory;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */

public class Primitive extends AbstractValue {
	
	public static class G implements GeneratorFactory
	{
		public boolean checkSupport(Class<?> clazz) {
			return clazz != null && clazz.isPrimitive();
		}
		
		public RandomValue newValueGenerator(Class<?> clazz, Type genericType){
			return new Primitive(clazz);
		}
	}

	Primitive(Class<?> clazz) {
		super(clazz);
	}
	
	@Override
	public Object generate( GenerateStrategy s) {
		
		if( clazz!= null && clazz.isPrimitive() ){
			switch( clazz.toString() ){
				case "byte":
					return (byte) (rnd.nextInt(Byte.MAX_VALUE) & 0xFF);
				case "short":
					return (short) (rnd.nextInt(Short.MAX_VALUE) & 0xFFFF);
				case "int":
					return rnd.nextInt( s.getIntegerRangeLimit() );
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
