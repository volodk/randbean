package org.randbean.values;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.randbean.core.JdkClasses;
import org.randbean.types.Randomizable;

public class ValueFactory {
    
    private static interface Condition {
        boolean canInstantiate(Class<?> clazz);
    }
    
    private static final Map<Condition, Randomizable> factories = new LinkedHashMap<>();
    
    static {
        
        add( new Condition() {
            @Override
            public boolean canInstantiate(Class<?> clazz) {
                return clazz.isPrimitive();
            }
        }, new PrimitiveValue());
        
        add( new Condition() {
            @Override
            public boolean canInstantiate(Class<?> clazz) {
                return String.class.isAssignableFrom(clazz);
            }
        }, new RandomizedString());
        
        add( new Condition() {
            @Override
            public boolean canInstantiate(Class<?> clazz) {
                return clazz.isArray();
            }
        }, new RandomizedArray());
        
        add( new Condition() {
            @Override
            public boolean canInstantiate(Class<?> clazz) {
                return clazz.isEnum();
            }
        }, new RandomizedEnum());
        
        add( new Condition() {
            @Override
            public boolean canInstantiate(Class<?> clazz) {
                return Date.class.isAssignableFrom(clazz);
            }
        }, new RandomizedDate());
        
        add( new Condition() {
            @Override
            public boolean canInstantiate(Class<?> clazz) {
                return JdkClasses.isKnown(clazz);
            }
        }, new RandomizedJdkObject());
        
        add( new Condition() {
            @Override
            public boolean canInstantiate(Class<?> clazz) {
                // is plain java bean in our classpath 
                return true;
            }
        }, new RandomizedJavaBean());
        
        add( new Condition() {
            @Override
            public boolean canInstantiate(Class<?> clazz) {
                return clazz.isInterface();
            }
        }, new ProxiedObject());
    }
    
    private static void add(Condition cond, Randomizable generator){
        factories.put(cond, generator);
    }
    
    public static Randomizable resolve(Class<?> clazz){
        for( Condition c : factories.keySet() ){
            if(c.canInstantiate(clazz))
                return factories.get(c);
        }
        return new NullValue();
    }

}
