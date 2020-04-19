package com.kushal.practice.project.leetcode.explore.arrays101;

final class FindMaxConsecutiveOnes
{
    /**
     * Finds the maximum length of consecutive 1's in an array.
     * @param nums input binary array.
     * 
     * @return the maximum length of consecutive 1's in an array.
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
            }
            else
            {
                maxLength = length;
                length = 0;
            }
        }
        return maxLength; 
    }
}
