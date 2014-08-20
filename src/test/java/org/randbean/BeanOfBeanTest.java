package org.randbean;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.randbean.junit.Randomize;
import org.randbean.junit.RandomizeRunner;
import org.randbean.samplebeans.Person;

@RunWith(RandomizeRunner.class)
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
