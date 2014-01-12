package org.nicebean.test;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nicebean.junit.Nice;
import org.nicebean.junit.NiceBeanRunner;

@RunWith(NiceBeanRunner.class)
public class BeanOfBeanTest {

  public static class Person {
    private String name;
    private int age;
    private byte[] privateArray;
    private Person bestFriend;
    
	@Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", privateArray=" + Arrays.toString(privateArray)
                + ", bestFriend=" + bestFriend + "]";
    }
  }

  @Nice Person person;

  @Test
  public void test() {
    
	  Assert.assertNotNull(person);
	  Assert.assertNotNull(person.bestFriend);
	  Assert.assertNotNull(person.bestFriend.bestFriend);
	  Assert.assertNotNull(person.bestFriend.bestFriend.bestFriend);
	  Assert.assertNotNull(person.bestFriend.bestFriend.bestFriend.bestFriend);
	  
	  Assert.assertNull(person.bestFriend.bestFriend.bestFriend.bestFriend.bestFriend);
	  
	  System.out.println(person);
	  
  }

}
