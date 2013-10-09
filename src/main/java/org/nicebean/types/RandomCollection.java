package org.nicebean.types;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.nicebean.annotations.Works;
import org.nicebean.types.ValueFactory.RandomValue;
import org.nicebean.utils.BeanUtils;

@Works(with = {Collection.class, List.class, Set.class})
public class RandomCollection extends AbstractValue {

	public RandomCollection(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Object generate(Size s) {
		if( clazz != null && Collection.class.isAssignableFrom(clazz) ){
			
			try {
				
				Object collection = BeanUtils.newInstance(clazz);	// TODO cannot instantiate interface
				
				Class<?> classType = getElementClassType(clazz);
				RandomValue rv = ValueFactory.resolve(classType);
				
				int size = rnd.nextInt( s.value() );
				while( size-- >0 ){

					Object element = rv.generate( Size.SHALLOW );
					
//					( (Collection) collection ).add( element );
				}
				
				return collection;
				
			} catch (InstantiationException | IllegalAccessException e) {
				System.err.println("Cannot instantiate class : " + clazz
						+ " , reason: " + e.getMessage());
			}
			
		} else{
			System.err.println("Is not a Collection");
		}
		return null;
	}

	private Class<?> getElementClassType(Class<?> clazz) {
		
//		Type type = clazz.
		
		return null;
	}

}
