package org.nicebean.values;

import org.nicebean.explorer.Builder;
import org.nicebean.explorer.Explorer;
import org.nicebean.types.AbstractValue;
import org.nicebean.utils.ReflectionUtils;

public class JavaBean extends AbstractValue {

    public JavaBean(Class<?> clazz) {
        super(clazz);
    }

    @Override
    protected Object doGenerate() {
        return Builder.newInstance( Explorer.structureOf(clazz) );
    }

    @Override
    protected Object doGenerateShallowValue() {
        return ReflectionUtils.newInstance(clazz);
    }
}
