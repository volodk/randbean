package org.randbean;


import static org.junit.Assert.assertNotNull;

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
    
	  assertNotNull(person);
	  assertNotNull(person.getBestFriend());
	  assertNotNull(person.getBestFriend().getBestFriend());
	  assertNotNull(person.getBestFriend().getBestFriend().getBestFriend());
	  assertNotNull(person.getBestFriend().getBestFriend().getBestFriend().getBestFriend());
	  
	  System.out.println(person);
	  
  }

}
