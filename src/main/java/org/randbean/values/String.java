package org.randbean.values;

import java.util.Random;

import org.randbean.types.Randomizable;
/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */

public class String implements Randomizable {
	
    private static final Random RND = new Random();
	private static final int MAX_LENGTH = 20;
	
	private Class<?> clazz;

    public String(Class<?> clazz) {
		this.clazz = clazz;
	}
    
    public String() {
        this(java.lang.String.class );
    }

	@Override
	public Object generate() {
		if( java.lang.String.class.isAssignableFrom(clazz) ){
			int length = 1 + RND.nextInt( MAX_LENGTH );
			char[] buff = new char[length];
			for(int i = 0; i < length; i++){
				char ch = 0;
				do {
					ch = (char) ( 'A' + RND.nextInt('z' - 'A' + 1));
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
