package org.nicebean.test;

import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nicebean.annotations.Nice;
import org.nicebean.junit.NiceBeanRunner;
import org.nicebean.types.GenerateStrategy;

@RunWith(NiceBeanRunner.class)
public class NiceBeanTest {

  public static class Person {
    private String name;
    private int age;
    private Person bestFriend;
    private Set<Person> peopleAround;
    
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", best friend=" + bestFriend
				+ ", people around = " + peopleAround + "]";
	}
  }

  @Nice(GenerateStrategy.SHALLOW) Person person;

  @Test
  public void test() {
    
	  Assert.assertNotNull(person);
	  
	  System.out.println(person);
	  
  }

}
