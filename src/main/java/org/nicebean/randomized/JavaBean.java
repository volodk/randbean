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
	    
	    Node root = Explorer.buildReferenceGraph(clazz);
	    
	    try{
            Object ref = BeanUtils.newInstance( clazz );
            
            for( Node element : root.getElements() ){
                
                Object value = null;
                
                Class<?> classType = element.getClassType();
                
                if( classType.isPrimitive() )
                    value = new Primitive(classType).generate();
                
                if( classType.isEnum() )
                    value = new Enum(classType).generate();
                
                if( classType.equals(java.lang.String.class) )
                    value = new String().generate();
                
                BeanUtils.setSilently( element.getField(), ref, value);
            }
            
            return ref;
            
        } catch ( InstantiationException | IllegalAccessException e ){
            System.err.println("Cannot create object instance, reason : " + e.getMessage());
        }
	    
	    return null;
	}
}
