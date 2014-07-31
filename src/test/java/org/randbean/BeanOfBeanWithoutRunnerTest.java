package org.randbean;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.randbean.junit.BeanRandomizer;
import org.randbean.junit.Randomize;
import org.randbean.samplebeans.Person;

public class BeanOfBeanWithoutRunnerTest {

  @Randomize Person person;
  
  @Before
  public void setUp() throws Exception{
      BeanRandomizer.init(this);
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
