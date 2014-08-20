package org.randbean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.randbean.junit.Randomize;
import org.randbean.junit.RandomizeRunner;
import org.randbean.samplebeans.AdvancedPerson;

@RunWith(RandomizeRunner.class)
public class BeanWithArrayOfBeansTest {

  @Randomize AdvancedPerson bean;

  @Test
  public void test() {
	  
	  System.out.println(bean);
	  
  }

}
