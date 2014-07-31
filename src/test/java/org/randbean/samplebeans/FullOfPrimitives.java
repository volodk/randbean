package org.randbean.samplebeans;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:52:30 PM 

public class FullOfPrimitives {

    private byte byteValue;
    private short shortValue;
    private char charValue;
    private int intValue;
    private long longValue;
    private float floatValue;
    private double doubleValue;
    
    @Override
    public String toString() {
        return "Primitives [byteValue=" + byteValue + ", shortValue="
                + shortValue + ", charValue=" + charValue + ", intValue="
                + intValue + ", longValue=" + longValue + ", floatValue="
                + floatValue + ", doubleValue=" + doubleValue + "]";
    }

    public byte getByteValue() {
        return byteValue;
    }

    public short getShortValue() {
        return shortValue;
    }

    public char getCharValue() {
        return charValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public long getLongValue() {
        return longValue;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }
    
    
}
