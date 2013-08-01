package org.randomizedbean.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.randomizedbean.Randomized;
import org.randomizedbean.junit.RandomizedBeanRunner;

@RunWith(RandomizedBeanRunner.class)
public class SampleTest {

  class Person {
  	int age;
  	String name;
  	Object anyObject;
  	Person dady, mom;
  	List<Person> children;
  	Serializable serializable;
  	Iterator<Person> neighbors;
    Person() {/*Constructor*/}
  }

  @Randomized
  Person bean;

  @Test
  public void test() {
    
  	assertNotNull(bean);
  	
  	assertNotNull ( bean.name );
  	assertTrue( bean.name.length() > 0 );
  	
  	assertNotNull(bean.anyObject);
  	
  	assertNotNull(bean.mom);
  	assertNotNull(bean.dady);
  	assertNotNull(bean.dady.name);
  	
  	// populate with random data collections : lists, sets, maps
  	assertNotNull(bean.children);
  	assertTrue(bean.children.size() > 0);
  	assertNotNull(bean.children.get(0).name);
  	
  	// support only limited set of types
  	assertNull(bean.neighbors);
  	assertNull(bean.serializable);
  	
  }

}
