package org.randbean.samplebeans;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 10:59:43 AM 

public class MultiConstructorBean {
    
    private int a;
    private float b;
    private String c;
    
    public MultiConstructorBean() {
        
    }
    
    public MultiConstructorBean(int a) {
        this.a = a;
    }
    
    public MultiConstructorBean(int a, float b) {
        this.a = a;
        this.b = b;
    }
    
    public MultiConstructorBean(int a, float b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int getA() {
        return a;
    }
    
    public float getB() {
        return b;
    }
    
    public String getC() {
        return c;
    }
    
}
