package org.randbean.values;

import org.randbean.types.AbstractValue;

public class NullValue extends AbstractValue {
    
    public NullValue() {
        this( Object.class );
    }

    public NullValue(Class<?> clazz) {
        super(clazz);
    }

    @Override
    protected Object doGenerate() {
        return null;
    }

}