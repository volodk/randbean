package org.randbean.values;

import org.randbean.explorer.Builder;
import org.randbean.explorer.Explorer;
import org.randbean.types.AbstractValue;
import org.randbean.utils.ReflectionUtils;

public class JavaBean extends AbstractValue {

    public JavaBean(Class<?> clazz) {
        super(clazz);
    }

    @Override
    protected Object doGenerate() {
        return Builder.newInstance( Explorer.explore(clazz) );
    }

    @Override
    protected Object doGenerateShallowValue() {
        return ReflectionUtils.newInstance(clazz);
    }
}
