package org.nicebean.test;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nicebean.junit.Nice;
import org.nicebean.junit.NiceBeanRunner;

@RunWith(NiceBeanRunner.class)
public class BeanWithArrayOfBeansTest {

   public static class Person {
    private String name;
    private Person[] bestFriends;   // array of bean population is not supported now, will be added soon
    
	@Override
    public String toString() {
        return "Person [name=" + name + ", bestFriends=" + Arrays.toString(bestFriends) + "]";
    }
  }

  @Nice Person person;

  @Test
  public void test() {
	  
	  System.out.println(person);
	  
  }

}
