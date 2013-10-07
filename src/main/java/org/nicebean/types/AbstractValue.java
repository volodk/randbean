package org.nicebean.types;

import java.util.Random;

import org.nicebean.types.ValueFactory.RandomValue;

public abstract class AbstractValue implements RandomValue {
	
	protected final Random rnd = new Random( System.currentTimeMillis() );
	
	protected Class<?> clazz;
	private boolean container;
	
	public AbstractValue(Class<?> clazz, boolean container) {
		this.clazz = clazz;
		this.container = container;
	}
	
	@Override
	public boolean isComplex() {
		return container;
	}
}
