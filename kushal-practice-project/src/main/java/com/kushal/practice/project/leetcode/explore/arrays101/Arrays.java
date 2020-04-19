package com.kushal.practice.project.leetcode.explore.arrays101;

/**
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * 
 * @author Kushalvtiger
 */
final class Arrays
{
    /**
     * Given a binary array, find the maximum number of consecutive 1s in this array.
     */
    static int findMaxConsecutiveOnes(int[] nums) 
    {
        int maxLength = 0; 
        int length = 0;
        int maxIndex = nums.length -1;
        for(int i = 0; i <= maxIndex; i++)
        {
            //Increment length for 1 and assign length to max length and reset length. 
            if(nums[i] == 1)
            {
                length ++;
                continue;
            }
            if(length>maxLength)
            {
                maxLength = length;
            }
            length = 0;
        }
        if(length>maxLength)
        {
            maxLength = length;
        }
        return maxLength; 
    }
    
    /**
     * Given an array nums of integers, return how many of them contain an even number of digits.
     * 1 <= nums.length <= 500
     * 1 <= nums[i] <= 10^5
     */
    static int findNumbers(int[] nums) 
    {
      int count = 0;
      for( int i=0; i< nums.length; i++)
      {
          int value = nums[i];
          if((value>9 && value<100) || (value> 999 && value< 10000))
          {
              count ++;
          }
      }
      return count;
    }
    
    /**
     * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
     * @param array 1 <= length <= 10000, -10000 <= array[i] <= 10000, array is sorted in non-decreasing order.
     * @return
     */
    static int[] sortedSquares(int[] array) 
    {
        
        int start = 0, end = array.length -1, counter = end;
        int[] result = new int[array.length];
        
        while(start <= end)
        {
            int startResult = array[start] * array[start];
            int endResult = array[end] * array[end]; 
            if(endResult> startResult)
            {
                result[counter] = endResult;
                end --;
            }
            else
            {
                result[counter] = startResult;
                start ++;
            }
            counter--;
        }
        return result;
        
    }
}
