package org.nicebean.explorer;

import java.lang.reflect.Type;

import org.nicebean.types.AbstractValue;
import org.nicebean.types.ValueFactory;
import org.nicebean.utils.ReflectionUtils;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 * 
 */
public class Builder {

    public static Object newInstance(Structure struct) {
        if (struct != null) {
            Class<?> classType = struct.getClassType();
            if (struct.isLeaf()) {
                Type genericType = struct.getGenericType();
                AbstractValue rv = ValueFactory.resolve(classType, genericType);
                return rv.generateShallow();

            } else {
                Object instance = ReflectionUtils.newInstance(classType);
                for (Structure element : struct.getElements()) {
                    Object value = newInstance(element);
                    ReflectionUtils.set(instance, element.getField(), value);
                }
                return instance;
            }
        }
        return null;
    }
}
