package kushal.practice.problems.algoexpert.easy;

import java.util.Arrays;

public class Greedy
{
    public static int minimumWaitingTime(int[] queries) 
    {
        Arrays.sort(queries);
        if(queries.length < 2)
        {
            return 0;
        }
        int minWaitingTime = 0;
        for(int i = 0 ; i < queries.length; i ++)
        {
            minWaitingTime = minWaitingTime + queries[i];
            if(i > 0)
            {
                queries[i] = queries[i-1] + minWaitingTime;
            }
        }
        
        return queries[queries.length - 2];
    }
    
    public static int minimumWaitingTimeDuration(int[] queries) 
    {
        Arrays.sort(queries);
        if(queries.length < 2)
        {
            return 0;
        }
        int minWaitingTime = 0;
        for(int i = 0 ; i < queries.length; i ++)
        {
            int duration = queries[i];
            int quiresLeft = queries.length - (i + 1);
            minWaitingTime = minWaitingTime + (quiresLeft * duration);
        }
        
        return minWaitingTime;
    }
}
