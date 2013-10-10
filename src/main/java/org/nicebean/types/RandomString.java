package org.nicebean.types;

import org.nicebean.annotations.Works;

@Works(with = String.class)
public class RandomString extends AbstractValue {

	public RandomString(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Object generate( DetailLevel s ) {
		
		if( clazz != null && String.class.isAssignableFrom(clazz) ){
			int length = rnd.nextInt( s.value() );
			char[] buff = new char[length];
			for(int i = 0; i < length; i++){
				char ch = 0;
				do {
					ch = (char) ( 'A' + rnd.nextInt('z' - 'A' + 1));
				} while( ch > 'Z' && ch < 'a' );
				buff[i] = ch;
			}
			return String.valueOf(buff);
		} else{
			System.err.println("Is not a String");
		}
		return null;
		
	}

}
