package org.nicebean.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nicebean.annotations.Nice;
import org.nicebean.junit.NiceBeanRunner;

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

  @Nice
  Person bean;

  @Test
  public void test() {
    
	  Assert.assertNotNull(bean);
	  
	  System.out.println(bean);
	  
  }

}
