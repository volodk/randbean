package org.randbean.utils;

import java.util.Objects;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 5:52:56 PM 

public class Preconditions {
    
    public static void notNull(Object obj){
        Objects.requireNonNull(obj);
    }
    
    public static <E extends Exception> void assertThat(boolean expression, E ex) throws E{
        if( expression == false )
            throw ex;
    }

}
