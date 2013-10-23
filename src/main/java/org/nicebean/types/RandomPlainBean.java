package org.nicebean.types;

import org.nicebean.explorer.Explorer;
import org.nicebean.explorer.Builder;
import org.nicebean.explorer.Node;

public class RandomPlainBean extends AbstractValue {

	public RandomPlainBean(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Object generate(DescribeStrategy strategy) {
		
		Class<?> clazz = getTargetClass();

		Node root = Explorer.buildReferenceGraph(clazz, strategy);
		
		return Builder.newInstance(root);
	}
}
