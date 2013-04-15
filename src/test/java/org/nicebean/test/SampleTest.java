package org.nicebean.test;

import static org.junit.Assert.fail;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nicebean.Nice;
import org.nicebean.junit.NiceBeanRunner;

@RunWith(NiceBeanRunner.class)
public class SampleTest {

  public static class Person {
    private String name;
    private int age;
    private Person dady, mom;
    private Set<Person> children;

    // add here default or null-argument constructor + getters & setters
  }

  @Nice
  Person $4test;

  @Test
  public void test() {
    fail("Not yet implemented");
  }

}
