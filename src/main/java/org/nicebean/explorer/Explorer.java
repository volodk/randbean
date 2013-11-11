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
	
	public static Node buildReferenceGraph(Class<?> rootClazz, GenerateStrategy strategy) {
		
		int maxDepth = strategy.followReferences() ? 10 : 1;
		
		return buildReferenceGraph(rootClazz, null, strategy, 0, maxDepth );
	}

	private static Node buildReferenceGraph(Class<?> clazz, Field classField, GenerateStrategy st, int currDepth, int maxDepth) {
		
		if ( currDepth <= maxDepth ) {
			
			Node node = new Node(clazz, classField);
			
			if ( isJdkClass(clazz) ) {	
				
				node.markAsLeaf();
				
			} else {
				
				if ( st.followReferences() ){
					Iterator<Field> it = Arrays.asList(clazz.getDeclaredFields()).iterator();
					
					boolean isLimitReached = false;
					
					while( it.hasNext() && !isLimitReached ){
						Field f = it.next();
						
						Node child = buildReferenceGraph(f.getType(), f, st, currDepth + 1, maxDepth);
				
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

	private static boolean isJdkClass(Class<?> clazz) {
		return JdkClassRegistry.isJdkClass(clazz);
	}
}
