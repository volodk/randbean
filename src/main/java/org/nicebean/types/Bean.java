package org.nicebean.types;

import org.nicebean.explorer.Explorer;
import org.nicebean.explorer.Instance;
import org.nicebean.explorer.Node;


public class Bean extends AbstractValue{

	public Bean(Class<?> clazz, boolean container) {
		super(clazz, container);
	}

	@Override
	public Object generate() {
		
		int maxDepth = 1;
		Node n = Explorer.buildReferenceGraph(clazz, maxDepth);
		
		boolean godeep = false;
		return Instance.newObject(n);
		
	}
	
}
