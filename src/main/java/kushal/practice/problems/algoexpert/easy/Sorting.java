package kushal.practice.problems.algoexpert.easy;

public class Sorting
{
    public static int[] bubbleSort(int[] array)
    {
        boolean swap = true;
        while (swap)
        {
            swap = false; 
            for(int i = 0; i< array.length - 1; i++)
            {
                if( array[i] > array[i + 1])
                {
                    int temp = array[i];
                    array[i] = array [i+1];
                    array[i+1] = temp;
                    swap = true;
                }
            }
        }
        
        return array;
    }
}
