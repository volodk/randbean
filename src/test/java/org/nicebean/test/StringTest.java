package org.nicebean.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nicebean.junit.Nice;
import org.nicebean.junit.NiceBeanRunner;

@RunWith(NiceBeanRunner.class)
public class StringTest {

	@Nice
	String str;

	@Test
	public void test() {

		assertNotNull(str);

		System.out.println(str);

	}

}
