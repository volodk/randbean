package org.nicebean.explorer;

import org.nicebean.BeanUtils;
import org.nicebean.types.ValueFactory;
import org.nicebean.types.ValueFactory.RandomValue;

public class Instance {
	
	public static Object newObject(Node node) {
		
		if ( node != null ){
			
			if( node.isLeaf() ){
				
				RandomValue rv = ValueFactory.resolve( node.getClassType() );
				
				return rv.generate();
				
			} else {
				
				try{
					Object ref = BeanUtils.newInstance( node.getClassType() );
					
					for( Node element : node.getElements() ){
					
						Object value = newObject(element);
						
						BeanUtils.setSilently( element.getClassField(), ref, value);
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
