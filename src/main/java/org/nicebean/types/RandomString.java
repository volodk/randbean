package org.nicebean.types;


/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */

public class RandomString extends AbstractValue implements Generable {
	
	public RandomString(Class<?> clazz) {
		super(clazz);
	}
	
	@Override
	public boolean canHandle(Class<?> clazz) {
		return String.class.isAssignableFrom(clazz);
	}

	@Override
	public Object generate( GenerateStrategy s ) {
		
		if( clazz != null && String.class.isAssignableFrom(clazz) ){
			int length = rnd.nextInt( s.getContainerSizeLimit() );
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
