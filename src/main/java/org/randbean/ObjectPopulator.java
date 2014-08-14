package org.randbean;

import java.util.Arrays;

import org.randbean.core.Builder;
import org.randbean.core.Explorer;

public class ObjectPopulator {
    
    private ObjectPopulator(){
        
    }
    
    public static Object getObjectOfType(Class<?> clazz){
        return Builder.newInstance(Explorer.explore(clazz));
    }
    
    public static class UseCase{
        private int intValue;
        private String strValue;
        private byte[] byteArr;
        
        @Override
        public String toString() {
            return "UseCase [intValue=" + intValue + ", strValue=" + strValue + ", byteArr=" + Arrays.toString(byteArr)
                    + "]";
        }
        
    }
    
    public static void main(String[] args) {
        Object o = getObjectOfType(UseCase.class);
        System.out.println(o);
    }
    
}
