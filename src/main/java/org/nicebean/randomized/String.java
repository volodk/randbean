package org.nicebean.randomized;

import org.nicebean.types.AbstractValue;
/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */

public class String extends AbstractValue {
	
	private static final int MAX_LENGTH = 20;

    public String(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Object generate( ) {
		
		if( clazz != null && java.lang.String.class.isAssignableFrom(clazz) ){
			int length = 1 + rnd.nextInt( MAX_LENGTH );
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
