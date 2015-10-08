package org.randbean.core;

import java.util.Objects;

import org.randbean.values.RandomizableValue;
import org.randbean.values.ValueFactory;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 * 
 */
public class Builder {

    public static Object newInstance(Model model) {
        Objects.requireNonNull(model);
        
        Class<?> clazz = model.getClassType();
        
        RandomizableValue r = ValueFactory.resolve(clazz);
        
        CreationMode mode = model.isLeaf() ? CreationMode.SHALLOW : CreationMode.DEEP;
        
        return r.instantiate(clazz, mode );
    }
}

