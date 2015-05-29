package org.randbean.core;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 * 
 */
public class Explorer {

    private static final int MAX_DEPTH = Integer.parseInt(System.getProperty("links.max.depth", "5"));

    public static Model explore(Class<?> clazz) {
        Objects.requireNonNull(clazz);
        return explore(clazz, null, /*start depth*/ 0);
    }

    public static Model explore(Field field) {
        Objects.requireNonNull(field);
        return explore(field.getType(), field, /*start depth*/ 0);
    }

    private static Model explore(Class<?> clazz, Field field, int depth) {
        if (depth > MAX_DEPTH) {
            return null;
        } else {
            Model node = Model.of(clazz).declaredAt(field);
            if (isDirectlyInstantiable(clazz)) {
                node.markAsLeaf();
            } else {
                for (Field f : clazz.getDeclaredFields()) {
                    Model child = explore(f.getType(), f, depth + 1);
                    if (child != null) {
                        node.addElement(child);
                    } else {
                        node.markAsLeaf();
                    }
                }
            }
            return node;
        }
    }

    private static boolean isDirectlyInstantiable(Class<?> clazz) {
        return JdkClasses.isKnown(clazz) || clazz.isArray() || clazz.isEnum() || clazz.isInterface();
    }
}
