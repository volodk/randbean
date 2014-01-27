package org.nicebean.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nicebean.junit.Nice;
import org.nicebean.junit.NiceBeanRunner;
import org.nicebean.test.domain.AdvancedPerson;

@RunWith(NiceBeanRunner.class)
public class BeanWithArrayOfBeansTest {

  @Nice AdvancedPerson bean;

  @Test
  public void test() {
	  
	  System.out.println(bean);
	  
  }

}
