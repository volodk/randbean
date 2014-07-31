package org.randbean.utils;

import java.util.Arrays;
import java.util.List;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 5:52:56 PM 

public class Preconditions {
    
    public interface Condition {
        boolean isTrue(List<Object> context);
    }
    
    public static void notNull(Object obj){
        Preconditions.check(new Condition() {
            @Override
            public boolean isTrue(List<Object> context) {
                return null != context.get(0);
            }
        }, IllegalArgumentException.class, obj);
    }
    
    public static void notNull(Object first, Object second){
        Preconditions.check(new Condition() {
            @Override
            public boolean isTrue(List<Object> context) {
                return null != context.get(0) && null != context.get(1);
            }
        }, IllegalArgumentException.class, first, second);
    }
    
    public static void notNull(Object first, Object second, Object third){
        Preconditions.check(new Condition() {
            @Override
            public boolean isTrue(List<Object> context) {
                return null != context.get(0) && null != context.get(1);
            }
        }, IllegalArgumentException.class, first, second, third);
    }
    
    public static <E extends Exception> void check( Condition condition, Class<E> exception, Object ... context) throws E {
        if( !condition.isTrue(Arrays.asList(context)) ){
            try {
                throw exception.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
