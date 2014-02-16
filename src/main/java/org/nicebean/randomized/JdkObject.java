package org.nicebean.randomized;

import org.nicebean.types.AbstractValue;

public class JdkObject extends AbstractValue{

    private final AbstractValue generator;
    
    public JdkObject(Class<?> clazz) {
        super(clazz);
        
        generator = resolveValueGenerator();
    }

    private final AbstractValue resolveValueGenerator() {
        
        if( String.class.equals(clazz) )
            return new org.nicebean.randomized.String(clazz);
        
        if( Date.class.equals(clazz) )
            return new org.nicebean.randomized.Date(clazz);
        
        return new NullValue();
        
    }

    @Override
    protected Object doGenerate() {
        return generator.generate();
    }

}
