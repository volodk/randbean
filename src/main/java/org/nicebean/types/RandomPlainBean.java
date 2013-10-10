package org.nicebean.types;

import org.nicebean.explorer.Explorer;
import org.nicebean.explorer.Builder;
import org.nicebean.explorer.Node;

public class RandomPlainBean extends AbstractValue {

	public RandomPlainBean(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Object generate(DetailLevel s) {
		Node root = Explorer.buildReferenceGraph(clazz, s.value());
		return Builder.newInstance(root);
	}
}
