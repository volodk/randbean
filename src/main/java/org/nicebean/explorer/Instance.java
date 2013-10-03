package org.nicebean.explorer;

import org.nicebean.Utils;
import org.nicebean.datagen.RandomizedValue;
import org.nicebean.datagen.RandomizedValueFactory;

public class Instance {
	
	public static Object newObject(Node node) {
		
		if ( node != null ){
			
			if( node.isLeaf() ){
				
				RandomizedValue rv = RandomizedValueFactory.resolve( node.getClassType() );
				
				return rv.generate();
				
			} else {
				try{
					Object ref = node.getClassType().newInstance();
					
					for( Node element : node.getElements() ){
					
						Object value = newObject(element);
						
						Utils.setSilently( element.getClassField(), ref, value);
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
