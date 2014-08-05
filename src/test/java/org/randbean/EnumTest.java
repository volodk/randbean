package org.randbean;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.randbean.junit.RandomizeRunner;
import org.randbean.junit.Randomize;

@RunWith(RandomizeRunner.class)
public class EnumTest {
    
    enum E{ A, B, C}

    @Randomize E e;
    
    @Test
    public void test() {

        Assert.assertNotNull(e);
        
        Assert.assertTrue(e == E.A || e == E.B || e == E.C);
        
        System.out.println(e);

    }

}
