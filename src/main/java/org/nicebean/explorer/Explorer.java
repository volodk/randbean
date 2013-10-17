package org.nicebean.explorer;

import java.lang.reflect.Field;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */
public class Explorer {
	
	public static Node buildReferenceGraph(Class<?> rootClazz, int maxDepth) {

		return buildReferenceGraph(rootClazz, null, 0, maxDepth);
	}

	private static Node buildReferenceGraph(Class<?> clazz, Field classField, int depth, final int limit) {
		
		if ( depth <= limit ) {
			
			Node node = new Node(clazz, classField);
			
			if ( isJdkClass(clazz) ) {	// TODO: cache here
				
				node.markAsLeaf();
				
			} else {
				
				for (Field f : clazz.getDeclaredFields()) {
					
					Node child = buildReferenceGraph(f.getType(), f, depth + 1, limit);
			
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
