package org.randbean.values;

import java.util.Objects;

import org.randbean.core.Builder;
import org.randbean.core.CreationMode;
import org.randbean.core.Explorer;
import org.randbean.utils.ReflectionUtils;

class RandomizedJavaBean implements RandomizableValue {

    @Override
    public Object instantiate(Class<?> clazz, CreationMode mode) {
        Objects.requireNonNull(clazz);
        if (CreationMode.DEEP == mode) {
            return Builder.newInstance(Explorer.explore(clazz));
        } else {
            return ReflectionUtils.newInstance(clazz);
        }
    }

}
