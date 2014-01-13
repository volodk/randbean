package org.nicebean.explorer;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 * 
 */
public class Explorer {

    private static final int MAX_DEPTH = 5;

    public static Node buildReferenceGraph(Class<?> rootClazz) {

        return buildRecursively(rootClazz, null, 0, MAX_DEPTH);
    }

    private static Node buildRecursively(Class<?> clazz, Field root, int currDepth, int maxDepth) {

        if (currDepth <= maxDepth) {

            Node node = new Node(clazz, root);

            if (isJdkClass(clazz) || clazz.isArray()) {

                node.markAsLeaf();

            } else {

                Iterator<Field> it = Arrays.asList(clazz.getDeclaredFields()).iterator();

                boolean isLimitReached = false;

                while (it.hasNext() && !isLimitReached) {
                    Field f = it.next();

                    Node child = buildRecursively(f.getType(), f, currDepth + 1, maxDepth);

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
