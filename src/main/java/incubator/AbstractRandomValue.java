package incubator;

public abstract class AbstractRandomValue implements RandomizedValue {
	
	protected Class<?> clazz;
	
	public AbstractRandomValue(Class<?> clazz) {
		this.clazz = clazz;
	}
}
