package org.nicebean.types;

import org.nicebean.explorer.Explorer;
import org.nicebean.explorer.Instance;
import org.nicebean.explorer.Node;

public class RandomPlainBean extends AbstractValue {

	public RandomPlainBean(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Object generate(Size s) {
		Node root = Explorer.buildReferenceGraph(clazz, s.value());
		return Instance.newObject(root);
	}
}
