package com.kushal.practice.project.leetcode.explore.arrays101;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for {@link FindMaxConsecutiveOnes}.
 * @author Kushal Venkategowda
 *
 */
public class FindMaxConsecutiveOnesTest
{
    /**
     * Testing {@link FindMaxConsecutiveOnes#findMaxConsecutiveOnes(int[])}.
     */
    @Test
    public void testfindMaxConsecutiveOnes()
    {
        assertEquals(2, FindMaxConsecutiveOnes.findMaxConsecutiveOnes(new int[] { 0, 1, 1, 0, 1}));
    }
}
