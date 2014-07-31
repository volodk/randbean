package org.randbean.values;

import org.randbean.types.Randomizable;

public class Date implements Randomizable {

    private Class<?> clazz;
    
	public Date(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	@Override
    public Object generate() {
		if( java.util.Date.class.isAssignableFrom(clazz) ){
			try {
				return clazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				System.err.println("Cannot instantiate 'Date' instance, datails :" + e.getMessage());
			}
		} else {
			System.err.println("Is not a Date");
		}
		return null;
	}

}
