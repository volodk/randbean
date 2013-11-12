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

public class String extends AbstractValue {
	
	public static class G implements GeneratorFactory
	{
		public boolean checkSupport(Class<?> clazz) {
			return java.lang.String.class.equals(clazz);
		}
		
		public RandomValue newValueGenerator(Class<?> clazz, Type genericType){
			return new String(clazz);
		}
	}
	
	public String(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Object generate( GenerateStrategy s ) {
		
		if( clazz != null && java.lang.String.class.isAssignableFrom(clazz) ){
			int length = rnd.nextInt( s.getContainerSizeLimit() );
			char[] buff = new char[length];
			for(int i = 0; i < length; i++){
				char ch = 0;
				do {
					ch = (char) ( 'A' + rnd.nextInt('z' - 'A' + 1));
				} while( ch > 'Z' && ch < 'a' );
				buff[i] = ch;
			}
			return java.lang.String.valueOf(buff);
		} else{
			System.err.println("Is not a String");
		}
		return null;
		
	}

}
