package org.nicebean;

import java.util.Arrays;

import org.nicebean.randomized.PlainBean;

public class JavaBeanPopulator {
    
    private JavaBeanPopulator(){
        
    }
    
    public static Object getFilledBeanOfType(Class<?> clazz){
        if(clazz != null){
            return new PlainBean(clazz).generate();
        }
        return null;
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
        Object o = getFilledBeanOfType(UseCase.class);
        System.out.println(o);
    }
    
}
