package org.nicebean.randomized;

import org.nicebean.explorer.Builder;
import org.nicebean.explorer.Explorer;
import org.nicebean.explorer.Node;
import org.nicebean.types.AbstractValue;
import org.nicebean.utils.BeanUtils;

public class JavaBean extends AbstractValue {
	
	public JavaBean(Class<?> clazz) {
		super(clazz);
	}

	@Override
	protected Object doGenerate() {
		
		Node root = Explorer.buildReferenceGraph(clazz);
		
		return Builder.newInstance(root);
	}
	
	@Override
	protected Object doGenerateShallowValue() {
	    
	    try{
            return BeanUtils.newInstance( clazz );
            
        } catch ( InstantiationException | IllegalAccessException e ){
            System.err.println("Cannot create object instance, reason : " + e.getMessage());
        }
	    
	    return null;
	}
}
