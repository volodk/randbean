package org.randbean;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.randbean.junit.Randomize;
import org.randbean.junit.RandomizeRunner;
import org.randbean.samplebeans.PersonEx;

@RunWith(RandomizeRunner.class)
public class BeanWithArrayOfBeansTest {

  @Randomize PersonEx bean;

  @Test
  public void test() {
      Assert.assertNotNull(bean);
	  System.out.println(bean);
  }
}
