package org.randbean;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.randbean.junit.RandomizeRunner;
import org.randbean.junit.Randomize;
import org.randbean.samplebeans.FullOfPrimitives;

@RunWith(RandomizeRunner.class)
public class BeanWithPrimitivesTest {

  @Randomize FullOfPrimitives bean;

  @Test
  public void test() {

	assertNotNull(bean);
	
    assertTrue(bean.getByteValue() != (byte) 0);		// might fail with probability P(A) = 1/256
    assertTrue(bean.getShortValue() != (short) 0);	// might fail with probability P(A) = 1/(Short.MAX_VALUE - Short.MIN_VALUE)
    assertTrue(bean.getCharValue() != '\u0000');		// returns chars between 'A' and 'z' inclusive
    assertTrue(bean.getIntValue() != 0);		// might fail with probability P(A) = 1/(Integer.MAX_VALUE - Integer.MIN_VALUE)
    assertTrue(bean.getLongValue() != 0L);	// might fail with probability P(A) = 1/(Long.MAX_VALUE - Long.MIN_VALUE)
    assertTrue(bean.getFloatValue() != 0.0f);	// might fail with probability P(A) = 1/float precision
    assertTrue(bean.getDoubleValue() != 0.0d);	// might fail with probability P(A) = 1/double precision
    
    System.out.println(bean);

  }

}
