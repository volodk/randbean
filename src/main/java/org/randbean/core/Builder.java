package org.randbean.core;

import org.randbean.utils.Preconditions;
import org.randbean.utils.ReflectionUtils;
import org.randbean.values.ValueFactory;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 * 
 */
public class Builder {

    public static Object newInstance(ClassNode node) {
        Preconditions.notNull(node);
        if (node.isLeaf()) {
            return ValueFactory.resolve(node).generate();
        } else {
            Class<?> rootObjectType = node.getClassType();
            Object rootObject = ReflectionUtils.newInstance(rootObjectType);
            for (ClassNode element : node.getElements()) {
                Object value = newInstance(element);
                ReflectionUtils.set(rootObject, element.getField(), value);
            }
            return rootObject;
        }
    }
}
