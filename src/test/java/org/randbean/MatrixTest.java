package org.randbean;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.randbean.junit.Randomize;
import org.randbean.junit.RandomizeRunner;

@RunWith(RandomizeRunner.class)
public class MatrixTest {

    @Randomize
    int[][] plane;

    @Randomize
    int space[][][];

    @Test
    public void test2DArray() {
        Assert.assertNotNull(plane);
        for (int[] line : plane) {
            System.out.println(Arrays.toString(line));
        }
    }
    
    @Test
    public void test3DArray() {
        Assert.assertNotNull(space);
        for (int[][] slice : space) {
            for (int[] line : slice) {
                System.out.println(Arrays.toString(line));
            }
        }
    }
}
