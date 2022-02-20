package kushal.practice.problems.algoexpert.easy;

import java.util.HashMap;
import java.util.Map;

public class Strings
{
    /** O(n) time n/2 == n| O(n) space*/
    public static boolean isPlaindromeSelf(final String input)
    {
       final char[] inputArray = input.toCharArray();
       final int lastIndex = inputArray.length -1;
       for(int i=0; i<= lastIndex/2; i++)
       {
           if(inputArray[i] != inputArray[lastIndex - i])
           {
               return false;
           }
       }
       return true;
    }
    
    /** O(n) time | O(n) space*/
    public static boolean isPlaindromeReverse(final String input)
    {
       final StringBuilder reverseString = new StringBuilder();
       for(int i= input.length() - 1; i >= 0; i--)
       {
           reverseString.append(input.charAt(i));
       }
       return input.equals(reverseString.toString());
    }

    /** O(n) time | O(n) space*/
    public static boolean isPlaindromeWhile(final String input)
    {
       final char[] inputArray = input.toCharArray();
       int firstIndex = 0;
       int lastIndex = inputArray.length -1;
       while (firstIndex < lastIndex)
       {
           if(inputArray[firstIndex] != inputArray[lastIndex])
           {
               return false;
           }
           firstIndex ++;
           lastIndex --;
       }
       return true;
    }
    
    /** O(n) time | O(1) space*/
    public static boolean isPlaindromeWhileSpace(final String input)
    {
       int firstIndex = 0;
       int lastIndex = input.length() -1;
       while (firstIndex < lastIndex)
       {
           if(input.charAt(firstIndex) != input.charAt(lastIndex))
           {
               return false;
           }
           firstIndex ++;
           lastIndex --;
       }
       return true;
    }

    /** O(n) time | O(n) space*/
    public static boolean isPlaindromeRecursion(final String input)
    {
        return isPlaindromeRecursion(input, 0);
    }

    /** O(n) time | O(n) space*/
    private static boolean isPlaindromeRecursion(final String input, int i)
    {
        int j = input.length() - i - 1;
        return i>= j? true : input.charAt(i) == input.charAt(j) && isPlaindromeRecursion(input, i +1);
    }
    
    /**------------------------------------------------------------------------------------------------------*/
    
    /** O(n) time | O(n) space*/
    public static String ceasarCypherEncryptorSelf(final String input, final int key)
    {
        final Map<Character, Integer> alphabetsMap = new HashMap(26);
        alphabetsMap.put('a', 0);alphabetsMap.put('b', 1);alphabetsMap.put('c', 2);alphabetsMap.put('d', 3);alphabetsMap.put('e', 4);
        alphabetsMap.put('f', 5);alphabetsMap.put('g', 6);alphabetsMap.put('h', 7);alphabetsMap.put('i', 8);alphabetsMap.put('j', 9);
        alphabetsMap.put('k', 10);alphabetsMap.put('l', 11);alphabetsMap.put('m', 12);alphabetsMap.put('n', 13);alphabetsMap.put('o', 14);
        alphabetsMap.put('p', 15);alphabetsMap.put('q', 16);alphabetsMap.put('r', 17);alphabetsMap.put('s', 18);alphabetsMap.put('t', 19);
        alphabetsMap.put('u', 20);alphabetsMap.put('v', 21);alphabetsMap.put('w', 22);alphabetsMap.put('x', 23);alphabetsMap.put('y', 24);
        alphabetsMap.put('z', 25);
        
        final char[] alphabets = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; 
        final StringBuilder output = new StringBuilder(input.length());
        final int lastIndex = input.length() -1;
        for(int i = 0; i<=lastIndex; i++)
        {
            final int currentIndex = alphabetsMap.get(input.charAt(i));
            final int newIndex = ((currentIndex + key) % 26);
            output.append(alphabets[newIndex]);
        }
        return output.toString();
    }
    
    /** O(n) time | O(n) space*/
    public static String ceasarCypherEncryptorAscii(final String input, final int key)
    {
        final char[] output = new char[input.length()];
        final int newKey = key % 26;
        final int length = input.length();
        for(int i = 0; i< input.length(); i++)
        {
            output[i] = getNewLetter(input.charAt(i), key);
        }
        return new String(output);
    }

    private static char getNewLetter(char letter, int key)
    {
        int newLetterCode = letter + key;
        return newLetterCode <=122 ?  (char) newLetterCode : (char) (96 + newLetterCode % 122);
    }
}
