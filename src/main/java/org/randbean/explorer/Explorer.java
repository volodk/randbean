package org.randbean.explorer;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;

import org.randbean.utils.Preconditions;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 * 
 */
public class Explorer {

    private static final int MAX_DEPTH = Integer.parseInt(System.getProperty("links.depth", "5"));

    public static ClassNode explore(Class<?> klass) {
        if( klass == null) return null;
        return explore(klass, null, 0);
    }
    
    public static ClassNode explore(Field field) {
        Preconditions.notNull(field);
        return explore(field.getType(), field, 0);
    }
    
    public static ClassNode explore(Class<?> klass, Field field) {
        Preconditions.notNull(klass);
        Preconditions.notNull(field);
        return explore(klass, field, 0);
    }

    private static ClassNode explore(Class<?> clazz, Field field, int depth) {
        if (depth <= MAX_DEPTH) {
            ClassNode node = ClassNode.from(clazz, field);
            if ( isDirectlyInstantiable(clazz) ) {
                node.markAsLeaf();
            } else {
                Iterator<Field> it = Arrays.asList(clazz.getDeclaredFields()).iterator();
                while ( it.hasNext() ) {
                    Field f = it.next();
                    ClassNode child = explore(f.getType(), f, depth + 1);
                    if (child != null)
                        node.addElement(child);
                    else {
                        node.markAsLeaf();
                    }
                }
            }
            return node;
        } else {
            return null;
        }
    }

    private static boolean isDirectlyInstantiable(Class<?> klass) {
        return JdkClasses.isKnown(klass) || klass.isArray() || klass.isEnum() || klass.isInterface();
    }
}
