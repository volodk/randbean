package org.nicebean.datagen;

import java.util.Random;

public class RandomizedPrimitive  extends AbstractRandomValue {

	public RandomizedPrimitive(Class<?> clazz) {
		super(clazz);
	}

	private static final Random rnd = new Random();
	
	@Override
	public Object get() {
		if( clazz!= null && clazz.isPrimitive() ){
			switch( clazz.toString() ){
				case "byte":
					return (byte)rnd.nextInt(Integer.MAX_VALUE) & 0xFF;
				case "short":
					return (short)rnd.nextInt(Integer.MAX_VALUE) & 0xFFFF;
				case "int":
					return rnd.nextInt();
				case "long":
					return rnd.nextLong();
				case "float":
					return rnd.nextFloat();
				case "double":
					return rnd.nextDouble();
				case "char":
					return (char)rnd.nextInt(Integer.MAX_VALUE) & 0xFFFF;
				case "boolean":
					return rnd.nextBoolean();
			}
		} else{
			System.err.println("Is not a primitive");
		}
		return null;
	}

}
