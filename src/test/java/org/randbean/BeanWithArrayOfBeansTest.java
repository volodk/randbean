package org.randbean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.randbean.junit.BeanRandomizerRunner;
import org.randbean.junit.Randomize;
import org.randbean.samplebeans.AdvancedPerson;

@RunWith(BeanRandomizerRunner.class)
public class BeanWithArrayOfBeansTest {

  @Randomize AdvancedPerson bean;

  @Test
  public void test() {
	  
	  System.out.println(bean);
	  
  }

}
