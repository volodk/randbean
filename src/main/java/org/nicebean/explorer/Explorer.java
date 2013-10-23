package org.nicebean.explorer;

import java.lang.reflect.Field;

import org.nicebean.types.DescribeStrategy;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */
public class Explorer {
	
	public static Node buildReferenceGraph(Class<?> rootClazz, DescribeStrategy level) {
		
		final int limit = level.depth();
		
		return buildReferenceGraph(rootClazz, null, level, 0, limit );
	}

	private static Node buildReferenceGraph(Class<?> clazz, Field classField, DescribeStrategy level, int depth, int limit) {
		
		if ( depth <= limit ) {
			
			Node node = new Node(clazz, classField);
			
			if ( isJdkClass(clazz) ) {	// TODO: cache here
				
				node.markAsLeaf();
				
			} else {
				
				if ( level.followReferences() ){
					for (Field f : clazz.getDeclaredFields()) {
						
						Node child = buildReferenceGraph(f.getType(), f, level, depth + 1, limit);
				
						if (child != null )
							node.addElement(child);
						else {
							node.markAsLeaf();
							break;
						}
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
