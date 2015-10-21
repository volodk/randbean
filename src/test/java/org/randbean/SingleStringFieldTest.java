package org.randbean;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.randbean.junit.Randomize;
import org.randbean.junit.RandomizeRunner;

@RunWith(RandomizeRunner.class)
public class SingleStringFieldTest {

	@Randomize
	String str;

	@Test
	public void test() {
		assertNotNull(str);
		System.out.println(str);
	}

}
