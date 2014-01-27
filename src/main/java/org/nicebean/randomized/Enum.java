package org.nicebean.randomized;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.nicebean.types.AbstractValue;
import org.nicebean.utils.ArrayUtils;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:44:56 PM 

public class Enum extends AbstractValue {

    public Enum(Class<?> enumClass) {
        super(enumClass);
    }

    @Override
    public Object generate() {
//        if (clazz.isEnum()) {
//
//            Field f;
//            do{
//                f = ArrayUtils.randomElement(clazz.getDeclaredFields());
//            } while( f.getModifiers() != (Modifier.PUBLIC & Modifier.STATIC & Modifier.FINAL) );
//
//            @SuppressWarnings({ "unchecked", "rawtypes" })
//            Object o = java.lang.Enum.valueOf((Class<java.lang.Enum>) clazz, f.getName());
//
//            return o;
//
//        }
        return null;
    }
}
