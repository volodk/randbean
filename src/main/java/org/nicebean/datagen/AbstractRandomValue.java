package org.nicebean.datagen;

import java.util.Random;

public abstract class AbstractRandomValue implements RandomizedValue {
	
	protected final Random rnd = new Random( System.currentTimeMillis() );
	
	protected Class<?> clazz;
	
	public AbstractRandomValue(Class<?> clazz) {
		this.clazz = clazz;
	}
}
