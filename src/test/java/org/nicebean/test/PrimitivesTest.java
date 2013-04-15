package org.nicebean.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nicebean.Nice;
import org.nicebean.junit.NiceBeanRunner;

@RunWith(NiceBeanRunner.class)
public class PrimitivesTest {

  public static class Primitives {
    private byte byteValue;
    private short shortValue;
    private char charValue;
    private int intValue;
    private long longValue;
    private float floatValue;
    private double doubleValue;

    // add here default or null-argument constructor + getters & setters
  }

  @Nice
  Primitives bean;

  @Test
  public void test() {

    assertTrue(bean.byteValue != (byte) 0);
    assertTrue(bean.shortValue != (short) 0);
    assertTrue(bean.charValue != '\u0000');
    assertTrue(bean.intValue != 0);
    assertTrue(bean.longValue != 0L);
    assertTrue(bean.floatValue != 0.0f);
    assertTrue(bean.doubleValue != 0.0d);

  }

}
