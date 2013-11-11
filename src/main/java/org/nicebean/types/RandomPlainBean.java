package org.nicebean.types;

import org.nicebean.explorer.Explorer;
import org.nicebean.explorer.Builder;
import org.nicebean.explorer.Node;

public class RandomPlainBean extends AbstractValue {

	public RandomPlainBean(Class<?> clazz) {
		super(clazz);
	}
	
	@Override
	public boolean canHandle(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object generate(GenerateStrategy gs) {
		
		Node root = Explorer.buildReferenceGraph(clazz, gs);
		
		return Builder.newInstance(root);
	}
}
