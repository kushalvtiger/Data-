package com.kushal.practice.project.leetcode.explore.arrays101;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test for {@link Arrays}.
 * @author Kushal Venkategowda
 *
 */
public class ArraysTest
{
    /**
     * Input: [1,1,0,1,1,1]
     * Output: 3
     * Explanation: The first two digits or the last three digits are consecutive 1s.
     * The maximum number of consecutive 1s is 3
     */
    @Test
    public void testFindMaxConsecutiveOnes()
    {
        assertEquals(2, Arrays.findMaxConsecutiveOnes(new int[] { 0, 1, 1, 0, 1}));
        assertEquals(0, Arrays.findMaxConsecutiveOnes(new int[] {0}));
        assertEquals(1, Arrays.findMaxConsecutiveOnes(new int[] {1}));
        assertEquals(1, Arrays.findMaxConsecutiveOnes(new int[] {0,1}));
    }
    
    /**
    *   Input: nums = [555,901,482,1771]
    *   Output: 1 
    *   Explanation: Only 1771 contains an even number of digits.
     */
    @Test
    public void testFindNumbers()
    {
        assertEquals(2, Arrays.findNumbers(new int[] {12,345,2,6,7896}));
        assertEquals(1, Arrays.findNumbers(new int[] {555,901,482,1771}));
        assertEquals(0, Arrays.findNumbers(new int[] {555}));
        assertEquals(1, Arrays.findNumbers(new int[] {1771}));
    }
    
    /**
     * Input: [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     */
    @Test
    public void testSortedSquares()
    {
        assertArrayEquals(new int[] {0,1,9,16,100}, Arrays.sortedSquares(new int[] {-4,-1,0,3,10}));
        assertArrayEquals(new int[] {4,9,9,49,121}, Arrays.sortedSquares(new int[] {-7,-3,2,3,11}));
    }
}
