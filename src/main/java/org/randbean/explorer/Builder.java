package org.randbean.explorer;

import org.randbean.utils.ReflectionUtils;
import org.randbean.values.ValueFactory;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 * 
 */
public class Builder {

    public static Object newInstance(ClassNode struct) {
        if (struct != null) {
            if (struct.isLeaf()) {
                return ValueFactory.resolve(struct).generate();
            } else {
                Class<?> rootObjectType = struct.getClassType();
                Object rootObject = ReflectionUtils.newInstance(rootObjectType);
                for ( ClassNode element : struct.getElements() ) {
                    Object value = newInstance(element);
                    ReflectionUtils.set(rootObject, element.getField(), value);
                }
                return rootObject;
            }
        }
        return null;
    }
}
