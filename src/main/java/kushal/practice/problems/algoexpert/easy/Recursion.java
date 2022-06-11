package kushal.practice.problems.algoexpert.easy;

public class Recursion
{
    public static int getNthFib(int n) 
    {
        if( n== 2)
        {
            return 1;
        }
        else if( n== 1)
        {
            return 0;
        }
        else
        {
            return getNthFib(n-1) + getNthFib(n -2);
        }
    }
    
    public static int getNthFibFor(int n) 
    {
        int first = 0;
        int second = 1;
        if(n <= 1)
        {
            return first;
        }
        else if(n<=3)
        {
            return second;
        }
        for (int i = 3; i<=n ; i++)
        {
            int result = first + second;
            first = second; 
            second = result;
        }
        return second;
    }
}
