package org.randbean.values;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.randbean.core.JdkClasses;

public class ValueFactory {
    
    private static interface Createable {
        boolean check(Class<?> clazz);
    }
    
    private static final Map<Createable, RandomizableValue> factories = new LinkedHashMap<>();
    
    static {
        
        add( new Createable() {
            @Override
            public boolean check(Class<?> clazz) {
                return clazz.isPrimitive();
            }
        }, new PrimitiveValue());
        
        add( new Createable() {
            @Override
            public boolean check(Class<?> clazz) {
                return String.class.isAssignableFrom(clazz);
            }
        }, new RandomizedString());
        
        add( new Createable() {
            @Override
            public boolean check(Class<?> clazz) {
                return clazz.isArray();
            }
        }, new RandomizedArray());
        
        add( new Createable() {
            @Override
            public boolean check(Class<?> clazz) {
                return clazz.isEnum();
            }
        }, new RandomizedEnum());
        
        add( new Createable() {
            @Override
            public boolean check(Class<?> clazz) {
                return Date.class.isAssignableFrom(clazz);
            }
        }, new RandomizedDate());
        
        add( new Createable() {
            @Override
            public boolean check(Class<?> clazz) {
                return JdkClasses.isKnown(clazz);
            }
        }, new RandomizedJdkObject());
        
        add( new Createable() {
            @Override
            public boolean check(Class<?> clazz) {
                return clazz.isInterface();
            }
        }, new ProxiedObject());
        
        add( new Createable() {
            @Override
            public boolean check(Class<?> clazz) {
                // is plain java bean in our classpath 
                return true;
            }
        }, new RandomizedJavaBean());
        
    }
    
    private static void add(Createable cond, RandomizableValue generator){
        factories.put(cond, generator);
    }
    
    public static RandomizableValue resolve(Class<?> clazz){
        for( Createable c : factories.keySet() ){
            if(c.check(clazz))
                return factories.get(c);
        }
        return new NullValue();
    }

}
