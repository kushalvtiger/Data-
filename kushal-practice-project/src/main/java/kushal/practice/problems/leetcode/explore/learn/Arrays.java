package kushal.practice.problems.leetcode.explore.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Main Class for Arrays.
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
        int maxIndex = nums.length - 1;
        for (int i = 0; i <= maxIndex; i++)
        {
            // Increment length for 1 and assign length to max length and reset length.
            if (nums[i] == 1)
            {
                length++;
                continue;
            }
            if (length > maxLength)
            {
                maxLength = length;
            }
            length = 0;
        }
        if (length > maxLength)
        {
            maxLength = length;
        }
        return maxLength;
    }

    /**
     * Given an array nums of integers, return how many of them contain an even number of digits.
     * @param nums  1 <= nums.length <= 500 1 <= nums[i] <= 10^5
     */
    static int findNumbers(int[] nums)
    {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            int value = nums[i];
            if ((value > 9 && value < 100) || (value > 999 && value < 10000))
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing
     * order.
     * @param array 1 <= length <= 10000, -10000 <= array[i] <= 10000, array is sorted in non-decreasing order.
     * @return sortedSquares
     */
    static int[] sortedSquares(int[] array)
    {

        int start = 0, end = array.length - 1, counter = end;
        int[] result = new int[array.length];

        while (start <= end)
        {
            int startResult = array[start] * array[start];
            int endResult = array[end] * array[end];
            if (endResult > startResult)
            {
                result[counter] = endResult;
                end--;
            }
            else
            {
                result[counter] = startResult;
                start++;
            }
            counter--;
        }
        return result;

    }

    /**
     * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
     * 
     * @param arr 1 <= arr.length <= 10000, 0 <= arr[i] <= 9
     */
    static int[] duplicateZeros(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == 0)
            {
                for (int j = arr.length - 2; j > i; j--)
                {
                    arr[j + 1] = arr[j];
                }
                if (i < arr.length - 1)
                {
                    arr[i + 1] = 0;
                    i++;
                }
            }
        }
        return arr;
    }

    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * 
     * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has enough space (size that is
     * greater or equal to m + n) to hold additional elements from nums2.
     */
    static int[] merge(int[] nums1, int m, int[] nums2, int n)
    {
        int i = 0, j = 0;
        int count = 0;
        int length = m + n;
        if (n == 0)
        {
            return nums1;
        }

        if (m == 0)
        {
            while (count < length)
            {
                nums1[count] = nums2[count];
                count++;
            }
            return nums1;
        }
        while (count < length && j < n)
        {
            if (nums1[i] <= nums2[j] && i < m)
            {
                nums1[count] = nums1[i];
                i++;
            }
            else
            {
                if (i < m)
                {
                    for (int k = length - 2; k >= count; k--)
                    {
                        nums1[k + 1] = nums1[k];
                    }
                    i++;
                    m++;
                }
                nums1[count] = nums2[j];
                j++;
            }
            count++;
        }
        return nums1;
    }

    /**
     * Given an array nums and a value val, remove all instances of that value in-place and return the new length. Do not allocate extra space for
     * another array, you must do this by modifying the input array in-place with O(1) extra memory. The order of elements can be changed. It doesn't
     * matter what you leave beyond the new length.
     */
    static int removeElement(int[] nums, int val)
    {
        int length = nums.length;
        for (int i = 0; i < length; i++)
        {
            if (nums[i] == val)
            {
                length--;
                for (int j = i; j < length; j++)
                {
                    nums[j] = nums[j + 1];
                }
                i--;
            }
        }
        return length;
    }

    /**
     * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length. Do not allocate
     * extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     */
    static int removeDuplicates(int[] nums)
    {
        int length = nums.length;
        for (int i = 1; i < length; i++)
        {
            if (nums[i] == nums[i - 1])
            {
                for (int j = i; j < length; j++)
                {
                    nums[j - 1] = nums[j];
                }
                length--;
                i--;
            }
        }
        return length;
    }

    /**
     * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
     * 
     * @param arr i != j; 0 <= i, j < arr.length; arr[i] == 2 * arr[j]
     */
    @SuppressWarnings("boxing")
    static boolean checkIfExist(int[] arr)
    {
        Map<Integer, Integer> doubles = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++)
        {
            int key = arr[i] * 2;
            if (doubles.containsKey(key) || doubles.containsValue(arr[i]))
            {
                return true;
            }
            doubles.put(arr[i], key);
        }
        return false;
    }

    /**
     * Given an array A of integers, return true if and only if it is a valid mountain array.
     * 
     * @param arr 0 <= A.length <= 10000, 0 <= A[i] <= 10000
     */
    static boolean validMountainArray(int[] arr)
    {
        if (arr.length < 3)
        {
            return false;
        }
        int breakPoint = 0;
        for (int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i + 1] <= arr[i])
            {
                breakPoint = i;
                break;
            }
        }
        if (breakPoint == 0)
        {
            return false;
        }
        for (int i = breakPoint; i < arr.length - 1; i++)
        {
            if (arr[i] <= arr[i + 1])
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element
     * with -1.
     * 
     * @param arr 1 <= arr.length <= 10^4; 1 <= arr[i] <= 10^5.
     */
    static int[] replaceElements(int[] arr)
    {
        int n = arr.length;
        int greatest = -1;
        int a;
        for (int i = n - 1; i >= 0; i--)
        {
            a = arr[i];
            arr[i] = greatest;
            greatest = Math.max(a, greatest);
        }
        return arr;
    }

    /**
     * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length. Do not allocate
     * extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     */
    static int[] copyWithRemovedDuplicates(int[] nums)
    {
        int length = 1;
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] != nums[i - 1])
            {
                nums[length] = nums[i];
                length++;
            }
        }
        return nums;
    }

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     */
    static int[] moveZeroes(int[] nums)
    {
        int start = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != 0)
            {
                nums[start] = nums[i];
                start++;
            }
        }
        for (int i = start; i < nums.length; i++)
        {
            nums[i] = 0;
        }
        return nums;
    }

    /**
     * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A. You
     * may return any answer array that satisfies this condition.
     * 
     * @param 1 <= A.length <= 5000; 0 <= A[i] <= 5000
     */
    static int[] sortArrayByParity(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] % 2 != 0)
            {
                boolean swap = false;
                for (int j = i + 1; j < arr.length; j++)
                {
                    if (arr[j] % 2 == 0)
                    {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        swap = true;
                        break;
                    }
                }
                if (!swap)
                {
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing
     * @param array 1 <= A.length <= 10000; -10000 <= A[i] <= 10000; A is sorted in non-decreasing order.
     */
    static int[] sortedSquares2(int[] array)
    {
        int counter = array.length - 1;
        while (counter >= 0)
        {
            int startResult = array[0] * array[0];
            int endResult = array[counter] * array[counter];
            if (endResult >= startResult)
            {
                array[counter] = endResult;
            }
            else
            {
                int temp = array[counter];
                array[counter] = startResult;
                array[0] = temp;
            }
            counter--;
        }
        return array;
    }

    /**
     * Students are asked to stand in non-decreasing order of heights for an annual photo. Return the minimum number of students that must move in
     * order for all students to be standing in non-decreasing order of height.
     * 
     * @param heights 1 <= heights.length <= 100, 1 <= heights[i] <= 100.
     */
    static int heightChecker(int[] heights)
    {
        int[] sortedArray = heights.clone();
        java.util.Arrays.sort(sortedArray);

        int swapCount = 0;
        for (int i = 0; i < heights.length; i++)
        {
            if (heights[i] != sortedArray[i])
            {
                swapCount++;
            }
        }

        return swapCount;
    }

    /**
     * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
     * 
     * @param nums The input array will only contain 0 and 1, The length of input array is a positive integer and will not exceed 10,000.
     */
    static int findMaxConsecutiveOnes2(int[] nums)
    {
        int maxCount = 0;
        boolean flipped = false;
        int result = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 1)
            {
                maxCount++;
            }
            else
            {
                if (!flipped)
                {
                    maxCount++;
                    flipped = true;
                    continue;
                }
                if (maxCount > result)
                {
                    result = maxCount;
                }
                maxCount = 0;
                flipped = false;
            }
        }
        return maxCount > result ? maxCount : result;
    }

    /**
     * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time
     * complexity must be in O(n).
     */
    static int thirdMax(int[] nums)
    {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums)
        {
            set.add(Integer.valueOf(num));
            {
                if (set.size() > 3)
                {
                    set.remove(Collections.min(set));
                }
            }
        }
        if (set.size() == 3)
        {
            return Collections.min(set).intValue();
        }
        return Collections.max(set).intValue();
    }

    /**
     * Given an array of integers, some elements appear twice and others appear once. Find all the elements of [1, n] inclusive that do not appear in
     * this array. Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
     */
    static Object[] findDisappearedNumbers(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            int index = Math.abs(nums[i]);
            nums[index - 1] = -1 * Math.abs(nums[index - 1]);
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > 0)
            {
                result.add(Integer.valueOf(i + 1));
            }
        }

        return result.toArray();
    }
}
