package org.nicebean.randomized;

import org.nicebean.types.AbstractValue;

public class NullValue extends AbstractValue {
    
    public NullValue() {
        this(null);
    }

    public NullValue(Class<?> clazz) {
        super(clazz);
    }

    @Override
    protected Object doGenerate() {
        // TODO Auto-generated method stub
        return null;
    }

}
