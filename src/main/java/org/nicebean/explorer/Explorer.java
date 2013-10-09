package org.nicebean.explorer;

import java.lang.reflect.Field;

public class Explorer {
	
	public static Node buildReferenceGraph(Class<?> rootClazz, int maxDepth) {

		return buildReferenceGraph(rootClazz, null, 0, maxDepth);
	}

	private static Node buildReferenceGraph(Class<?> clazz, Field classField, int depth, int max_depth) {
		
		if (depth <= max_depth) {
			
			Node node = new Node(clazz, classField);
			
			if ( isJdkClass(clazz) ) {
				
				node.markAsLeaf();
				
			} else {
				
				for (Field f : clazz.getDeclaredFields()) {
					
					Node child = buildReferenceGraph(f.getType(), f, depth + 1, max_depth);
			
					if (child != null)
						node.addElement(child);
					else {
						node.markAsLeaf();
						break;
					}
				}
			}
			return node;
			
		}
		return null;
	}

	private static boolean isJdkClass(Class<?> clazz) {
		return JdkClassRegistry.isJdkClass(clazz);
	}
}
