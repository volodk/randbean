package org.randbean;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.randbean.junit.Randomize;
import org.randbean.junit.RandomizeRunner;

@RunWith(RandomizeRunner.class)
public class SinglePrimitiveTest {

    @Randomize
    byte value;
    
    @Test
    public void test() {
        System.out.println(value);
        
        byte DEFAULT_VALUE = 0;
        
        Assert.assertTrue(value != DEFAULT_VALUE);  // might fail with probability P(A) = 1/256
    }

}
