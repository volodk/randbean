package org.nicebean.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nicebean.junit.Nice;
import org.nicebean.junit.NiceBeanRunner;

@RunWith(NiceBeanRunner.class)
public class PojoTest {

  public static class Primitives {
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

    // add here default or null-argument constructor + getters & setters
    
  }

  @Nice Primitives bean;

  @Test
  public void test() {

	assertNotNull(bean);
	
    assertTrue(bean.byteValue != (byte) 0);		// might fail with probability P(A) = 1/256
    assertTrue(bean.shortValue != (short) 0);	// might fail with probability P(A) = 1/(Short.MAX_VALUE - Short.MIN_VALUE)
    assertTrue(bean.charValue != '\u0000');		// returns chars between 'A' and 'z' inclusive
    assertTrue(bean.intValue != 0);		// might fail with probability P(A) = 1/(Integer.MAX_VALUE - Integer.MIN_VALUE)
    assertTrue(bean.longValue != 0L);	// might fail with probability P(A) = 1/(Long.MAX_VALUE - Long.MIN_VALUE)
    assertTrue(bean.floatValue != 0.0f);	// might fail with probability P(A) = 1/float precision
    assertTrue(bean.doubleValue != 0.0d);	// might fail with probability P(A) = 1/double precision
    
    System.out.println(bean);

  }

}
