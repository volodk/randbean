package org.nicebean.types;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Iterator;

public class ValueFactory {
	
	static final Generable[] generators = {};
	
	private static final RandomValue NULL_OBJECT_VALUE = new RandomValue(){
		@Override
		public Object generate(GenerateStrategy d) {
			return null;
		}
	};
	
	public static RandomValue resolve(Class<?> clazz){
		return resolve(clazz, null);
	}
	
	public static RandomValue resolve(Class<?> clazz, Type genericType){
		
		RandomValue rv = NULL_OBJECT_VALUE;
		
		Iterator<Generable> it = Arrays.asList(generators).iterator();
		boolean found = false;
		while(it.hasNext() && found){
			Generable g = it.next();
			if( found = g.canHandle(clazz) ){
				rv = (RandomValue) g;
			}
		}
		
		return rv;
	}

}
