package org.nicebean.types;

import java.util.Random;

import org.nicebean.types.ValueFactory.RandomValue;

public abstract class AbstractValue implements RandomValue {
	
	protected final Random rnd = new Random( System.currentTimeMillis() );
	
	protected static final int ARRAY_SIZE_LIMIT = 10;
	protected static final int INTEGER_LIMIT = 100;
	
	protected Class<?> clazz;
	
	public AbstractValue(Class<?> clazz) {
		this.clazz = clazz;
	}
}
