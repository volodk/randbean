package incubator;

public class RandomizedArray  extends AbstractRandomValue {

	public RandomizedArray(Class<?> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object get() {
		if( clazz != null && clazz.isArray() ){
			
		} else {
			System.err.println("Is not an Array");
		}
		return null;
	}

}
