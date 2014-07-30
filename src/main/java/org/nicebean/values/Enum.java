package org.nicebean.values;

import org.nicebean.types.AbstractValue;
import org.nicebean.utils.ArrayUtils;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:44:56 PM 

public class Enum extends AbstractValue {

    public Enum(Class<?> enumClass) {
        super(enumClass);
    }

    @Override
    protected Object doGenerate() {
        if (clazz.isEnum()) {
            return ArrayUtils.randomElement(clazz.getEnumConstants());
        }
        return null;
    }
}
