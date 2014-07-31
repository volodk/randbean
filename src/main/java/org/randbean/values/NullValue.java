package org.randbean.values;

import org.randbean.types.Randomizable;

public class NullValue implements Randomizable {
    
    @Override
    public Object generate() {
        return null;
    }

}
