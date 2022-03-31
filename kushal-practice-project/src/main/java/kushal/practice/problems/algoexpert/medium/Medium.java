package kushal.practice.problems.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Medium
{
    public static List<Integer[]> threeNumberSum(Integer[] array, int targetSum)
    {
        final HashMap<Integer, Integer> firstDifferent = new HashMap();
        final ArrayList<Integer[]> result = new ArrayList();
        final List<Integer> inputList = Arrays.asList(array);
        for (final Integer firstDiff : array)
        {
            firstDifferent.put(firstDiff, targetSum - firstDiff);
        }

        for (final Entry<Integer, Integer> secondDiff : firstDifferent.entrySet())
        {
            if (inputList.contains(targetSum - secondDiff.getValue()) && inputList.contains(secondDiff.getValue()))
            {
                result.add(new Integer[] { secondDiff.getKey(), secondDiff.getValue(), targetSum - secondDiff.getValue() });
            }

        }

        return result;
    }

    public static int kadanesAlgorithm(int[] array)
    {
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < array.length - 1; i++)
        {
            for (int j = i; j < array.length; j++)
            {
                sum += array[j];
                if (j >= 3)
                {
                    System.out.println(i + "=" + sum);
                }

                if (sum > result)
                {
                    result = sum;
                    System.out.println(i + "Result" + result);
                }
            }
            sum = 0;
        }
        return result;
    }
}
