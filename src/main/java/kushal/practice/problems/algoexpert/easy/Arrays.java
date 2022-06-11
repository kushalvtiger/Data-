package kushal.practice.problems.algoexpert.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Arrays
{

    /** O(n^2) time | O(1) space */
    public static int[] twoNumberSum(int[] array, int targetSum)
    {
        final int length = array.length;
        for (int i = 0; i < length - 1; i++)
        {
            for (int j = i + 1; j < length; j++)
            {
                if (array[i] + array[j] == targetSum)
                {
                    return new int[] { array[i], array[j] };
                }
            }
        }
        return new int[0];
    }

    /** O(n) time | O(1) space */
    public static int[] twoNumberSumSet(int[] array, int targetSum)
    {
        final HashSet<Integer> set = new HashSet();
        for (int firstNumber : array)
        {
            int secondNumber = targetSum - firstNumber;
            if (set.contains(secondNumber))
            {
                return new int[] { firstNumber, secondNumber };
            }
            set.add(firstNumber);
        }
        return new int[0];
    }

    /** O(n logn) time | O(1) space */
    public static int[] twoNumberSumSorted(int[] array, int targetSum)
    {
        java.util.Arrays.sort(array);

        int left = 0;
        int right = array.length - 1;

        while (left < right)
        {
            int currentSum = array[left] + array[right];
            if (currentSum == targetSum)
            {
                return new int[] { array[left], array[right] };
            }
            else if (currentSum < targetSum)
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return new int[0];
    }

    /** O(n) time | O(1) space */
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence)
    {
        int size = sequence.size();
        int counter = 0;
        for (final Integer number : array)
        {
            if (counter >= size)
            {
                return true;
            }
            // Checks if the array contains the number
            if (number == sequence.get(counter))
            {
                counter++;
            }
        }

        return counter == size;
    }

    /** O(n) time | O(n) space */
    public int[] sortedSquaredArray(int[] array)
    {
        int startIndex = 0;
        int endIndex = array.length - 1;
        final int[] result = new int[array.length];
        int counter = array.length - 1;
        while (startIndex <= endIndex)
        {
            int startResult = array[startIndex] * array[startIndex];
            int endResult = array[endIndex] * array[endIndex];
            if (startResult > endResult && counter >= 0)
            {
                result[counter] = startResult;
                startIndex++;
            }
            else
            {
                result[counter] = endResult;
                endIndex--;
            }
            counter--;
        }
        return result;
    }

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results)
    {
        Map<String, Integer> winners = new HashMap();
        int highestScore = 0;
        String champion = null;
        final int size = results.size();
        for (int i = 0; i < size; i++)
        {
            final List<String> compitation = competitions.get(i);
            final int result = results.get(i);
            String currentWinner;
            if (result == 0)
            {
                currentWinner = compitation.get(1);
            }
            else
            {
                currentWinner = compitation.get(0);
            }
            Integer score = winners.get(currentWinner);
            if (score == null)
            {
                score = 0;
            }
            score = score + 3;
            winners.put(currentWinner, score);
            if (score > highestScore)
            {
                highestScore = score;
                champion = currentWinner;
            }
        }
        return champion;
    }

    /** O(nlogn) Time | O(1) */
    public int nonConstructibleChange(int[] coins)
    {
        java.util.Arrays.sort(coins);
        int minChange = 0;
        for (int i = 0; i < coins.length; i++)
        {
            int currentCoin = coins[i];
            if (currentCoin > minChange + 1)
            {
                return minChange + 1;
            }
            minChange += currentCoin;
        }
        return minChange + 1;
    }

    static class Node
    {
        String name;

        List<Node> children = new ArrayList<Node>();

        public Node(String name)
        {
            this.name = name;
        }

        /** Time O(n+h) | Time (O)n */
        public List<String> depthFirstSearch(List<String> array)
        {
            array.add(this.name);
            for (final Node child : children)
            {
                child.depthFirstSearch(array);
            }
            return array;
        }

        public Node addChild(String name)
        {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    /** Space O(1)| Time O(nlogn) */
    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights)
    {
        Collections.sort(redShirtHeights, Collections.reverseOrder());
        Collections.sort(blueShirtHeights, Collections.reverseOrder());
        final String topColor = blueShirtHeights.get(0) >= redShirtHeights.get(0) ? "BLUE" : "RED";
        final int size = blueShirtHeights.size();
        for (int i = 0; i < size; i++)
        {
            if (topColor == "BLUE" && redShirtHeights.get(i) >= blueShirtHeights.get(i))
            {
                return false;
            }
            if (topColor == "RED" && redShirtHeights.get(i) <= blueShirtHeights.get(i))
            {
                return false;
            }
        }
        return true;
    }

    /** Space O(1) | Time(nlogn)*/
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest)
    {
        java.util.Arrays.sort(redShirtSpeeds);
        java.util.Arrays.sort(blueShirtSpeeds);
        if (!fastest)
        {
            reverseArray(redShirtSpeeds);
        }
        int last = redShirtSpeeds.length - 1;
        int speed = 0;
        for (int i = 0, j = last; i <= last; i++, j--)
        {
            speed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[j]);
        }
        return speed;
    }

    public void reverseArray(int[] array)
    {
        int start = 0;
        int end = array.length - 1;
        while (start < end)
        {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
