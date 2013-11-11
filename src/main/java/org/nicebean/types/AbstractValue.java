package org.nicebean.types;

import java.lang.reflect.Type;
import java.util.Random;

public abstract class AbstractValue implements RandomValue, Generable {
	
	protected final Random rnd = new Random( System.currentTimeMillis() );
	
	protected Class<?> clazz;
	protected Type genericType;
	
	public AbstractValue(Class<?> clazz) {
		this(clazz, null);
	}
	
	public AbstractValue(Class<?> clazz, Type genericType) {
		this.clazz = clazz;
		this.genericType = genericType;
	}
	
}
