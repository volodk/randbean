package org.nicebean.explorer;

import java.lang.reflect.Type;

import org.nicebean.types.RandomValue;
import org.nicebean.types.ValueFactory;
import org.nicebean.utils.BeanUtils;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */
public class Builder {
	
	public static Object newInstance(Node node) {
		
		if ( node != null ){
			
			Class<?> classType = node.getClassType();
			
			if( node.isLeaf() ){
				
				Type genericType = node.getGenericType();
				
				RandomValue rv = ValueFactory.resolve( classType, genericType );
				
				return rv.generate();
				
			} else {
				
				try{
					Object ref = BeanUtils.newInstance( classType );
					
					for( Node element : node.getElements() ){
					
						Object value = newInstance(element);
						
						BeanUtils.setSilently( element.getField(), ref, value);
					}
					return ref;
					
				} catch ( InstantiationException | IllegalAccessException e ){
					System.err.println("Cannot create object instance, reason : " + e.getMessage());
				}
			}
			
		}
		
		return null;
	}
	
}
