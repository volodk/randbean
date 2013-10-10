package org.nicebean.explorer;

import org.nicebean.types.ValueFactory;
import org.nicebean.types.ValueFactory.RandomValue;
import org.nicebean.types.ValueFactory.RandomValue.DetailLevel;
import org.nicebean.utils.BeanUtils;

public class Builder {
	
	public static Object newInstance(Node node) {
		
		if ( node != null ){
			
			Class<?> classType = node.getClassType();
			
			if( node.isLeaf() ){
				
				RandomValue rv = ValueFactory.resolve( classType, node.getField().getGenericType() );
				
				return rv.generate( DetailLevel.SHALLOW );
				
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
