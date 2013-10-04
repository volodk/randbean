package org.nicebean.types;

public class RandomString extends AbstractValue {
	
	private static final int MAX_LENTH = 25;

	public RandomString(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Object generate() {
		if( clazz!= null && String.class.isAssignableFrom(clazz) ){
			int length = rnd.nextInt(MAX_LENTH);
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
