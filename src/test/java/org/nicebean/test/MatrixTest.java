package org.nicebean.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nicebean.junit.Nice;
import org.nicebean.junit.NiceBeanRunner;

@RunWith(NiceBeanRunner.class)
public class MatrixTest {

    @Nice
    int[][] plane;

    @Nice
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
