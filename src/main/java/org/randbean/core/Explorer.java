package org.randbean.core;

import java.lang.reflect.Field;

import org.randbean.utils.Preconditions;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 * 
 */
public class Explorer {

    private static final int MAX_DEPTH = Integer.parseInt(System.getProperty("links.max.depth", "5"));

    public static ClassNode explore(Class<?> clazz) {
        Preconditions.notNull(clazz);
        return explore(clazz, null, 0);
    }

    public static ClassNode explore(Field field) {
        Preconditions.notNull(field);
        return explore(field.getType(), field, 0);
    }

    public static ClassNode explore(Class<?> clazz, Field field) {
        Preconditions.notNull(clazz);
        Preconditions.notNull(field);
        return explore(clazz, field, 0);
    }

    private static ClassNode explore(Class<?> clazz, Field field, int depth) {
        if (depth > MAX_DEPTH) {
            return null;
        } else {
            ClassNode node = ClassNode.from(clazz, field);
            if (isDirectlyInstantiable(clazz)) {
                node.markAsLeaf();
            } else {
                for (Field f : clazz.getDeclaredFields()) {
                    ClassNode child = explore(f.getType(), f, depth + 1);
                    if (child != null)
                        node.addElement(child);
                    else {
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
