package org.randbean.values;

import org.randbean.types.Randomizable;

public class JdkObject implements Randomizable {

    private Class<?> clazz;
    
    public JdkObject(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object generate() {
        return null;
    }

}
