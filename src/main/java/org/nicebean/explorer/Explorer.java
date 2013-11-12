package org.nicebean.explorer;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;

import org.nicebean.types.GenerateStrategy;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */
public class Explorer {
	
	public static Node buildReferenceGraph(Class<?> rootClazz, GenerateStrategy gs) {
		
		int maxDepth = gs.followReferences() ? 10 : 1;
		
		return buildReferenceGraph(rootClazz, null, gs, 0, maxDepth );
	}

	private static Node buildReferenceGraph(Class<?> clazz, Field root, GenerateStrategy gs, int currDepth, int maxDepth) {
		
		if ( currDepth <= maxDepth ) {
			
			Node node = new Node(clazz, root);
			
			if ( isJdkClass(clazz) ) {	
				
				node.markAsLeaf();
				
			} else {
				
				if ( followReferences(gs, root) ){
					
					Iterator<Field> it = Arrays.asList(clazz.getDeclaredFields()).iterator();
					
					boolean isLimitReached = false;
					
					while( it.hasNext() && !isLimitReached ){
						Field f = it.next();
						
						Node child = buildReferenceGraph(f.getType(), f, gs, currDepth + 1, maxDepth);
				
						if (child != null )
							node.addElement(child);
						else {
							isLimitReached = node.markAsLeaf();
						}
					} 
				}
				
			}
			return node;
			
		}
		return null;
	}

	private static boolean followReferences(GenerateStrategy gs, Field root) {
		if( root == null && gs.followReferences() == false ){	// shallow mode from JUnit. No internal exploration
			return true;
		}
		return gs.followReferences();
	}

	private static boolean isJdkClass(Class<?> clazz) {
		return JdkClassRegistry.isJdkClass(clazz);
	}
}
