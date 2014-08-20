package org.randbean.values;

import java.util.Objects;

import org.randbean.core.CreationMode;
import org.randbean.types.Randomizable;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 1:52:56 PM 

class ProxiedObject implements Randomizable {

    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Objects.requireNonNull(clazz);
        return null;
    }

}
