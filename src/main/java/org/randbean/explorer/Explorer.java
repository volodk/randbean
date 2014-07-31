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

    public static ClassStructure explore(Class<?> klass) {
        Objects.requireNonNull(klass, "Target class cannot be null");
        return explore(klass, null, 0);
    }

    private static ClassStructure explore(Class<?> klass, Field field, int depth) {
        if (depth <= MAX_DEPTH) {
            ClassStructure node = ClassStructure.from(klass, field);
            if ( isJdkClass(klass) || klass.isArray() || klass.isEnum() || klass.isInterface() ) {
                node.markAsLeaf();
            } else {
                Iterator<Field> it = Arrays.asList(klass.getDeclaredFields()).iterator();
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
