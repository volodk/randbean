package org.nicebean.types;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Iterator;

import org.nicebean.types.random.Array;
import org.nicebean.types.random.Collection;
import org.nicebean.types.random.Date;
import org.nicebean.types.random.Map;
import org.nicebean.types.random.PlainBean;
import org.nicebean.types.random.Primitive;
import org.nicebean.types.random.String;

public class ValueFactory {
	
	static final GeneratorFactory[] generators = { new Primitive.G(),
			new String.G(), new Array.G(), new Collection.G(), new Date.G(),
			new Map.G(), new PlainBean.G() };
	
	private static final RandomValue NULL_OBJECT_VALUE = new RandomValue(){
		@Override
		public Object generate(GenerateStrategy gs) {
			return null;
		}
	};
	
	public static RandomValue resolve(Class<?> clazz){
		return resolve(clazz, null);
	}
	
	public static RandomValue resolve(Class<?> clazz, Type genericType){
		
		RandomValue rv = NULL_OBJECT_VALUE;
		
		Iterator<GeneratorFactory> it = Arrays.asList(generators).iterator();
		boolean found = false;
		while(it.hasNext() && !found){
			GeneratorFactory g = it.next();
			if( found = g.checkSupport(clazz) ){
				rv = g.newValueGenerator(clazz, genericType);
			}
		}
		
		return rv;
	}

}
