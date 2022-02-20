package kushal.practice.problems.algoexpert.easy;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreedyTest
{
    @Test
    public void testMinWaitingTime() {
      int[] queries = new int[] {3, 2, 1, 2, 6};
      int expected = 17;
      assertTrue(Greedy.minimumWaitingTime(queries) == expected);
    }

}
