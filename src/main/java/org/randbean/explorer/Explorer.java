package org.randbean.explorer;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 * 
 */
public class Explorer {

    private static final int MAX_DEPTH = Integer.parseInt(System.getProperty("links.depth", "5"));

    public static ClassStructure explore(Class<?> rootClazz) {
        Objects.requireNonNull(rootClazz, "Target class cannot be null");
        return explore(rootClazz, null, 0);
    }

    private static ClassStructure explore(Class<?> clazz, Field root, int depth) {
        if (depth <= MAX_DEPTH) {
            ClassStructure node = new ClassStructure(clazz, root);
            if ( isJdkClass(clazz) || clazz.isArray() || clazz.isEnum() || clazz.isInterface() ) {
                node.markAsLeaf();
            } else {
                Iterator<Field> it = Arrays.asList(clazz.getDeclaredFields()).iterator();
                boolean isLimitReached = false;
                while (it.hasNext() && !isLimitReached) {
                    Field f = it.next();
                    ClassStructure child = explore(f.getType(), f, depth + 1);
                    if (child != null)
                        node.addElement(child);
                    else {
                        isLimitReached = node.markAsLeaf();
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
