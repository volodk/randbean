package org.nicebean.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nicebean.Nice;
import org.nicebean.junit.NiceBeanRunner;

@RunWith(NiceBeanRunner.class)
public class PrimitiveTest {

	@Nice
	byte value;
	
	@Test
	public void test() {
		System.out.println(value);
		
		byte DEFAULT_VALUE = 0;
		
		Assert.assertTrue(value != DEFAULT_VALUE);	// might fail with probability P(A) = 1/256
	}

}
