package org.randbean.explorer;

import java.lang.reflect.Type;

import org.randbean.types.AbstractValue;
import org.randbean.types.ValueFactory;
import org.randbean.utils.ReflectionUtils;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 * 
 */
public class Builder {

    public static Object newInstance(ClassStructure struct) {
        if (struct != null) {
            Class<?> classType = struct.getClassType();
            if (struct.isLeaf()) {
                Type genericType = struct.getGenericType();
                AbstractValue rv = ValueFactory.resolve(classType, genericType);
                return rv.generateShallow();

            } else {
                Object instance = ReflectionUtils.newInstance(classType);
                for (ClassStructure element : struct.getElements()) {
                    Object value = newInstance(element);
                    ReflectionUtils.set(instance, element.getField(), value);
                }
                return instance;
            }
        }
        return null;
    }
}
