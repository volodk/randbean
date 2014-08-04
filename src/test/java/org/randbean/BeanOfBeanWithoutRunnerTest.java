package org.randbean;


import static org.junit.Assert.assertNotNull;

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
    
      assertNotNull(person);
      assertNotNull(person.getBestFriend());
      assertNotNull(person.getBestFriend().getBestFriend());
      assertNotNull(person.getBestFriend().getBestFriend().getBestFriend());
      assertNotNull(person.getBestFriend().getBestFriend().getBestFriend().getBestFriend());
      
	  System.out.println(person);
	  
  }

}
