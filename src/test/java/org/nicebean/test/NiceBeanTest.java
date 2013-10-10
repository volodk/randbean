package org.nicebean.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nicebean.annotations.Nice;
import org.nicebean.junit.NiceBeanRunner;
import org.nicebean.types.ValueFactory.RandomValue.DetailLevel;;

@RunWith(NiceBeanRunner.class)
public class NiceBeanTest {

  public static class Person {
    private String name;
    private int age;
    private Person friend;
//    private Set<Person> children;
    
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", friend=" + friend
				+ "]";
	}

    // add here default or null-argument constructor + getters & setters
  }

  @Nice(level = DetailLevel.DEEP)
  Person $4test;

  @Test
  public void test() {
    
	  Assert.assertNotNull($4test);
	  
	  System.out.println($4test);
	  
  }

}
