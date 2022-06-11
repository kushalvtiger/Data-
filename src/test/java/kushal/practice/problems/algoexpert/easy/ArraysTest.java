package kushal.practice.problems.algoexpert.easy;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class ArraysTest
{
    @Test
    public void testTwoNumberSum()
    {
        assertTrue(Arrays.equals(new int[] {4,1}, kushal.practice.problems.algoexpert.easy.Arrays.twoNumberSum(new int[]{ 4, 1, 6} , 5)));
    }

}
