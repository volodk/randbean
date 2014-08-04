package org.randbean.values;

import org.randbean.types.Randomizable;

class NullValue implements Randomizable {
    
    @Override
    public Object generate() {
        return null;
    }

}
