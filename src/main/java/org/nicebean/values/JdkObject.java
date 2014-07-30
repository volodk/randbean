package org.nicebean.values;

import org.nicebean.types.AbstractValue;

public class JdkObject extends AbstractValue{

    private final AbstractValue generator;
    
    public JdkObject(Class<?> clazz) {
        super(clazz);
        
        generator = resolveValueGenerator();
    }

    private final AbstractValue resolveValueGenerator() {
        
        if( String.class.equals(clazz) )
            return new org.nicebean.values.String(clazz);
        
        if( Date.class.equals(clazz) )
            return new org.nicebean.values.Date(clazz);
        
        return new NullValue();
        
    }

    @Override
    protected Object doGenerate() {
        return generator.generate();
    }

}
