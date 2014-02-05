package org.nicebean.randomized;

import org.nicebean.types.RandomValue;

public class NullValue implements RandomValue {

    @Override
    public Object generate() {
        return null;
    }

}
