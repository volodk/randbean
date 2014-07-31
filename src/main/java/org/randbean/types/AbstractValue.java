package org.randbean.types;

import java.lang.reflect.Type;
import java.util.Random;

import org.randbean.utils.Assert;

public abstract class AbstractValue implements RandomValue, ShallowRandomValue {
	
	protected final Random rnd = new Random();
	
	protected Class<?> clazz;
	protected Type genericType;
	
	public AbstractValue(Class<?> clazz) {
		this(clazz, null);
	}
	
	public AbstractValue(Class<?> clazz, Type genericType) {
	    Assert.notNull(clazz);
		this.clazz = clazz;
		this.genericType = genericType;
	}
	
	@Override
	public Object generate() {
	    return doGenerate();
	}
	
	@Override
	public Object generateShallow() {
	    return doGenerateShallowValue();
	}
	
	protected Object doGenerateShallowValue(){
	    return doGenerate();
	}
	
	protected abstract Object doGenerate();
	
}
