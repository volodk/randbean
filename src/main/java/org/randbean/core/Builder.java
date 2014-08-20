package org.randbean.core;

import java.util.Objects;

import org.randbean.types.Randomizable;
import org.randbean.utils.ReflectionUtils;
import org.randbean.values.ValueFactory;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 * 
 */
public class Builder {

    public static Object newInstance(ClassNode node) {
        Objects.requireNonNull(node);
        if (node.isLeaf()) {
            Class<?> clazz = node.getClassType();
            Randomizable r = ValueFactory.resolve(clazz);
            return r.instantiate(clazz, CreationMode.SHALLOW );
        } else {
            Class<?> rootObjectType = node.getClassType();
            Object rootObject = ReflectionUtils.newInstance(rootObjectType);
            for (ClassNode child : node.getElements()) {
                Object value = newInstance(child);
                ReflectionUtils.set(rootObject, child.getField(), value);
            }
            return rootObject;
        }
    }
}
