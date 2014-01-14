package org.nicebean.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nicebean.junit.Nice;
import org.nicebean.junit.NiceBeanRunner;
import org.nicebean.test.domain.Person;

@RunWith(NiceBeanRunner.class)
public class BeanOfBeanTest {

  @Nice Person person;

  @Test
  public void test() {
    
	  Assert.assertNotNull(person);
	  Assert.assertNotNull(person.getBestFriend());
	  Assert.assertNotNull(person.getBestFriend().getBestFriend());
	  Assert.assertNotNull(person.getBestFriend().getBestFriend().getBestFriend());
	  Assert.assertNotNull(person.getBestFriend().getBestFriend().getBestFriend().getBestFriend());
	  
	  Assert.assertNull(person.getBestFriend().getBestFriend().getBestFriend().getBestFriend().getBestFriend());
	  
	  System.out.println(person);
	  
  }

}
