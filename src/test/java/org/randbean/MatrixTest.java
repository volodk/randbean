package org.randbean;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.randbean.junit.BeanRandomizerRunner;
import org.randbean.junit.Randomize;

@RunWith(BeanRandomizerRunner.class)
public class MatrixTest {

    @Randomize
    int[][] plane;

    @Randomize
    int space[][][];

    @Test
    public void test() {

        Assert.assertNotNull(plane);

        for (int[] line : plane) {
            System.out.println(Arrays.toString(line));
        }

        System.out.println();

        Assert.assertNotNull(space);

        for (int[][] slice : space) {
            for (int[] line : slice) {
                System.out.println(Arrays.toString(line));
            }
        }
    }

}
