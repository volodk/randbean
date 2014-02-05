package org.nicebean.randomized;

import org.nicebean.explorer.Builder;
import org.nicebean.explorer.Explorer;
import org.nicebean.explorer.Node;
import org.nicebean.types.AbstractValue;

public class PlainBean extends AbstractValue {
	
	public PlainBean(Class<?> clazz) {
		super(clazz);
	}

	@Override
	protected Object doGenerate() {
		
		Node root = Explorer.buildReferenceGraph(clazz);
		
		return Builder.newInstance(root);
	}
}
