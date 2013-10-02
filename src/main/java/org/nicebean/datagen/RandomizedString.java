package org.nicebean.datagen;


public class RandomizedString extends AbstractRandomValue {

	public RandomizedString(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Object get() {
		if( clazz!= null && String.class.isAssignableFrom(clazz) ){
			
		} else{
			System.err.println("Is not a String");
		}
		return null;
	}

}
