package kushal.practice.problems.companies.oracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Strings
{
    // O(N) O(N)
    public List<String> topKFrequent(String[] words, int k)
    {
        final Map<String, Integer> map = new HashMap();
        for (String s : words)
        {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        Queue<String> heap = new PriorityQueue(new Comparator<String>()
        {
            public int compare(String o1, String o2)
            {
                if (map.get(o1) == map.get(o2)) 
                {
                    return o1.compareTo(o2);
                }
                return map.get(o2) - map.get(o1);
            }
        });

        for (final String s : map.keySet())
        {
            heap.offer(s);
        }

        List<String> res = new ArrayList();
        for (int i = 0; i < k; i++)
        {
            res.add(heap.poll());
        }
        return res;
    }

    // Time MaxK.n, Space m + n
    String decodeString(String s)
    {
        Stack<Integer> countStack = new Stack();
        Stack<StringBuilder> stringStack = new Stack();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray())
        {
            if (Character.isDigit(ch))
            {
                k = k * 10 + ch - '0';
            }
            else if (ch == '[')
            {
                // push the number k to countStack
                countStack.push(k);
                // push the currentString to stringStack
                stringStack.push(currentString);
                // reset currentString and k
                currentString = new StringBuilder();
                k = 0;
            }
            else if (ch == ']')
            {
                StringBuilder decodedString = stringStack.pop();
                // decode currentK[currentString] by appending currentString k times
                for (int currentK = countStack.pop(); currentK > 0; currentK--)
                {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            }
            else
            {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }

    // Time O(maxK^countK . n) Space O(sum(maxK^countK.n))
    public String decodeStringStack(String s)
    {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == ']')
            {
                List<Character> decodedString = new ArrayList();
                // get the encoded string
                while (stack.peek() != '[')
                {
                    decodedString.add(stack.pop());
                }
                // pop [ from the stack
                stack.pop();
                int base = 1;
                int k = 0;
                // get the number k
                while (!stack.isEmpty() && Character.isDigit(stack.peek()))
                {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }
                // decode k[decodedString], by pushing decodedString k times into stack
                while (k != 0)
                {
                    for (int j = decodedString.size() - 1; j >= 0; j--)
                    {
                        stack.push(decodedString.get(j));
                    }
                    k--;
                }
            }
            // push the current character to stack
            else
            {
                stack.push(s.charAt(i));
            }
        }
        // get the result from stack
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--)
        {
            result[i] = stack.pop();
        }
        return new String(result);
    }
    // O(1) O(n)
    public boolean isAnagram(String s, String t)
    {
        if (s.length() != t.length())
        {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++)
        {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter)
        {
            if (count != 0)
            {
                return false;
            }
        }
        return true;
    }

    // O(nlogn) O(1)
    public boolean isAnagramSort(String s, String t)
    {
        if (s.length() != t.length())
        {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    // O(NKlogK) O(NK)
    public List<List<String>> groupAnagrams(String[] strs)
    {
        if (strs.length == 0)
        {
            return new ArrayList();
        }
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs)
        {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key))
            {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    // Space O(N+M) Time O(N+M)
    public String mostCommonWordMap(String paragraph, String[] banned)
    {
        String ans = "";
        int maxCount = 0;

        // 1). replace the punctuation with spaces,
        // and put all letters in lower case
        final String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        // 2). split the string into words
        final String[] words = normalizedStr.split("\\s+");

        Set<String> bannedWords = new HashSet<String>();
        for (final String word : banned)
        {
            bannedWords.add(word);
        }

        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        // 3). count the appearance of each word, excluding the banned words
        for (final String word : words)
        {
            if (!bannedWords.contains(word))
            {
                int newCount = wordCount.getOrDefault(word, 0) + 1;
                wordCount.put(word, newCount);
                if (newCount > maxCount)
                {
                    ans = word;
                    maxCount = newCount;
                }
            }
        }

        // 4). return the word with the highest frequency
        return ans;
    }

    // Space O(N+M) Time O(N+M)
    public String mostCommonWord(String paragraph, String[] banned)
    {
        final Set<String> bannedWords = new HashSet<String>();
        for (final String word : banned)
        {
            bannedWords.add(word);
        }

        String ans = "";
        int maxCount = 0;
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        StringBuilder wordBuffer = new StringBuilder();
        char[] chars = paragraph.toCharArray();

        for (int p = 0; p < chars.length; ++p)
        {
            char currChar = chars[p];

            // 1). consume the characters in a word
            if (Character.isLetter(currChar))
            {
                wordBuffer.append(Character.toLowerCase(currChar));
                if (p != chars.length - 1)
                    // skip the rest of the processing
                    continue;
            }

            // 2). at the end of one word or at the end of paragraph
            if (wordBuffer.length() > 0)
            {
                String word = wordBuffer.toString();
                // identify the maximum count while updating the wordCount table.
                if (!bannedWords.contains(word))
                {
                    int newCount = wordCount.getOrDefault(word, 0) + 1;
                    wordCount.put(word, newCount);
                    if (newCount > maxCount)
                    {
                        ans = word;
                        maxCount = newCount;
                    }
                }
                // reset the buffer for the next word
                wordBuffer = new StringBuilder();
            }
        }
        return ans;
    }

    // Space O(n) Time O(n)
    public List<String> fullJustify(String[] words, int maxWidth)
    {
        // list to be returned
        List<String> list = new ArrayList();

        // store the combined word length in *section* list
        int length = 0;
        // *section* list to store the words at current iteration
        List<String> section = new ArrayList();
        for (int i = 0; i < words.length; i++)
        {
            // if and only if the word that we are currently looking at exceeds the wordWidth limit
            // we start to build a solution at this level
            if (length + section.size() + words[i].length() > maxWidth)
            {
                // number of spaces total
                int diff = maxWidth - length;
                StringBuilder sb = new StringBuilder();
                int spaceCount = section.size() > 1 ? diff / (section.size() - 1) : diff;

                // extra spaces when we can't evenly distribute them
                int extraCount = section.size() > 1 ? diff % (section.size() - 1) : 0;
                diff -= extraCount;
                for (int j = 0; j < section.size(); j++)
                {
                    sb.append(section.get(j));
                    if (extraCount > 0)
                    {
                        addSpace(sb, 1);
                        extraCount -= 1;
                    }
                    if (diff > 0)
                    {
                        addSpace(sb, spaceCount);
                        diff -= spaceCount;
                    }
                }

                list.add(sb.toString());
                // clear section list for next iteration
                section.clear();
                // clear length counter for next iteration
                length = 0;
            }
            section.add(words[i]);
            length += words[i].length();
        }
        // build the last line differently
        if (!section.isEmpty())
        {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int j = 0; j < section.size(); j++)
            {
                sb.append(section.get(j));
                if (j != section.size() - 1)
                {
                    addSpace(sb, 1);
                    count += 1;
                }
            }
            int diff = maxWidth - length - count;
            addSpace(sb, diff);
            list.add(sb.toString());
        }

        return list;
    }

    // helper function to append spaces to string builder
    private void addSpace(StringBuilder sb, int count)
    {
        for (int i = 0; i < count; i++)
        {
            sb.append(" ");
        }
    }

    // O(min(m,n)) O(n)
    public int lengthOfLongestSubstring(String s)
    {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++)
        {
            if (map.containsKey(s.charAt(j)))
            {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
