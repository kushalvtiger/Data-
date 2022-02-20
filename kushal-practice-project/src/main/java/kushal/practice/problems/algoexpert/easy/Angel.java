package kushal.practice.problems.algoexpert.easy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Angel
{

    // Space O(1)/O(n) Time O(n)
    public static int firstNonRepeatingString(final String inputString)
    {
        final char[] charArray = inputString.toCharArray();
        final int size = charArray.length;
        final Map<Character, Integer> indexMap = new LinkedHashMap<Character, Integer>(26);
        for (int i = 0; i < size; i++)
        {
            final char letter = charArray[i];
            if (indexMap.containsKey(letter))
            {

                indexMap.put(letter, size);
            }
            else
            {
                indexMap.put(letter, i);
            }
        }
        for (final Entry<Character, Integer> entry : indexMap.entrySet())
        {
            if (entry.getValue() < size)
            {
                return entry.getValue();
            }
        }
        return -1;
    }

    //
    public static Collection<List<String>> anagrams(final String[] arrayOfAnagrams)
    {
        final Map<String, List<String>> anagramsMap = new HashMap();
        //
        for (int i = 0; i < arrayOfAnagrams.length; i++)
        {
            final String firstString = arrayOfAnagrams[i];
            final String secondString = arrayOfAnagrams[i + 1];

            if (anagramsMap.containsKey(firstString))
            {
                final boolean isAnagram = isAnagram(firstString, secondString);
                if (isAnagram)
                {
                    final List<String> anagrams = anagramsMap.get(firstString);
                    anagrams.add(secondString);
                }
                else
                {
                    anagramsMap.put(firstString, new ArrayList<String>());
                }
            }
        }

        return anagramsMap.values();
    }

    private static boolean isAnagram(final String aString, final String bString)
    {
        final char[] aArray = aString.toCharArray();
        final char[] bArray = aString.toCharArray();
        final Map<Character, Integer> anagramChecker = new HashMap<Character, Integer>();
        for (final Character a : aArray)
        {
            if (anagramChecker.containsKey(a))
            {
                anagramChecker.put(a, anagramChecker.get(a) + 1);
            }
            else
            {
                anagramChecker.put(a, 1);
            }
        }

        for (final Character b : bArray)
        {
            final int count = anagramChecker.get(b);
            if (count < 1)
            {
                return false;
            }
            else if (count == 1)
            {
                anagramChecker.remove(b);
            }
            else
            {
                anagramChecker.put(b, count - 1);
            }
        }

        return anagramChecker.isEmpty();
    }

    public static String intToRoman(int number)
    {
        final StringBuilder string = new StringBuilder();
        final String[] romanNumerals = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        final int[] numerals = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        int i = 0;
        while (i < numerals.length)
        {
            if(number < 1)
            {
                break;
            }
            if (number >= numerals[i])
            {
                string.append(romanNumerals[i]);
                number -= numerals[i];
            }
            else
            {
                i++;
            }
            
        }
        return string.toString();
    }

}
