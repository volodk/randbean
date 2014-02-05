package org.nicebean.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nicebean.junit.Nice;
import org.nicebean.junit.NiceBeanRunner;

@RunWith(NiceBeanRunner.class)
public class EnumTest {
    
    enum E{ A, B, C}

    @Nice E e;
    
    @Test
    public void test() {

        Assert.assertNotNull(e);
        
        Assert.assertTrue(e == E.A || e == E.B || e == E.C);
        
        System.out.println(e);

    }

}
