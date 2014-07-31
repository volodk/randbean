package org.randbean;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.randbean.junit.BeanRandomizerRunner;
import org.randbean.junit.Randomize;
import org.randbean.samplebeans.Person;

@RunWith(BeanRandomizerRunner.class)
public class BeanOfBeanTest {

  @Randomize Person person;

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
