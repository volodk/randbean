package incubator;

import java.util.Collection;

public class RandomizedCollection extends AbstractRandomValue {

	public RandomizedCollection(Class<?> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object get() {
		
		if( clazz != null && Collection.class.isAssignableFrom(clazz) ){
			
		} else{
			System.err.println("Is not a Collection");
		}
		return null;
	}

}
