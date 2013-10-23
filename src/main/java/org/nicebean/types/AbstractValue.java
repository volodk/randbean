package org.nicebean.types;

import java.util.Random;

import org.nicebean.types.ValueFactory.RandomValue;

public abstract class AbstractValue implements RandomValue {
	
	protected final Random rnd = new Random( System.currentTimeMillis() );
	
	private Class<?> clazz;
	
	public AbstractValue(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	protected final Class<?> getTargetClass(){
		return clazz;
	}
	
}
