package org.nicebean.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.nicebean.junit.Nice;
import org.nicebean.junit.NiceBean;
import org.nicebean.test.domain.Person;

public class BeanOfBeanWithoutRunnerTest {

  @Nice Person person;
  
  @Before
  public void setUp() throws Exception{
      NiceBean.init(this);
  }

  @Test
  public void test() {
    
      Assert.assertNotNull(person);
      Assert.assertNotNull(person.getBestFriend());
      Assert.assertNotNull(person.getBestFriend().getBestFriend());
      Assert.assertNotNull(person.getBestFriend().getBestFriend().getBestFriend());
      Assert.assertNotNull(person.getBestFriend().getBestFriend().getBestFriend().getBestFriend());
      
	  System.out.println(person);
	  
  }

}
