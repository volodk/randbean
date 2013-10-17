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
		
		if( DetailLevel.SHALLOW == s ){
			
			return null;
			
		} else {
			final int depth = s.value();
			Node root = Explorer.buildReferenceGraph(clazz, depth);
			return Builder.newInstance(root);
		}
	}
}
