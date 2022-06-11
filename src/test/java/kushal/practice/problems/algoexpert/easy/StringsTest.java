package kushal.practice.problems.algoexpert.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StringsTest
{
    @Test
    public void isPlaindromeTest()
    {
        final List<String> sInputs = Arrays.asList("abcdcba", "a", "aba", "abba", "abcdefghhgfedcba", "abcdefghihgfedcba");
        for(String input: sInputs)
        {
            assertTrue(Strings.isPlaindromeSelf(input));
            assertTrue(Strings.isPlaindromeRecursion(input));
            assertTrue(Strings.isPlaindromeReverse(input));
            assertTrue(Strings.isPlaindromeWhile(input));
            assertTrue(Strings.isPlaindromeWhileSpace(input));
        }
        
        final List<String> fInputs = Arrays.asList("ab", "abb", "abcdefghihgfeddcba");
        for(String input: fInputs)
        {
            assertFalse(Strings.isPlaindromeSelf(input));
            assertFalse(Strings.isPlaindromeRecursion(input));
            assertFalse(Strings.isPlaindromeReverse(input));
            assertFalse(Strings.isPlaindromeWhile(input));
            assertFalse(Strings.isPlaindromeWhileSpace(input));
        }
    }

    
    @Test
    public void ceasarCypherEncryptorTest()
    {
        assertEquals("zab", Strings.ceasarCypherEncryptorSelf("xyz", 2));
        assertEquals("abc", Strings.ceasarCypherEncryptorSelf("abc", 0));
        assertEquals("def", Strings.ceasarCypherEncryptorSelf("abc", 3));
        assertEquals("cde", Strings.ceasarCypherEncryptorSelf("xyz", 5));
        assertEquals("abc", Strings.ceasarCypherEncryptorSelf("abc", 26));
        assertEquals("abc", Strings.ceasarCypherEncryptorSelf("abc", 52));
        assertEquals("fgh", Strings.ceasarCypherEncryptorSelf("abc", 57));
        assertEquals("wxy", Strings.ceasarCypherEncryptorSelf("xyz", 25));
        assertEquals("hvtepmjpjpnnkwyykyhgpel", Strings.ceasarCypherEncryptorSelf("iwufqnkqkqoolxzzlzihqfm", 25));
        assertEquals("tcrshocqjuidxcabatmhmrdpbhnqrgtgdnm", Strings.ceasarCypherEncryptorSelf("mvklahvjcnbwqvtutmfafkwiuagjkzmzwgf", 7));
        assertEquals("ovmqkwtujqmfkao", Strings.ceasarCypherEncryptorSelf("ovmqkwtujqmfkao", 52));
        assertEquals("zylbcipjkyycbhpvlvplzpvujpjvywplvcplvywplyvplquplvwthw", Strings.ceasarCypherEncryptorSelf("kjwmntauvjjnmsagwgawkagfuaugjhawgnawgjhawjgawbfawghesh", 15));
    
        assertEquals("zab", Strings.ceasarCypherEncryptorAscii("xyz", 2));
        assertEquals("abc", Strings.ceasarCypherEncryptorAscii("abc", 0));
        assertEquals("def", Strings.ceasarCypherEncryptorAscii("abc", 3));
        assertEquals("cde", Strings.ceasarCypherEncryptorAscii("xyz", 5));
//        assertEquals("abc", Strings.ceasarCypherEncryptorAscii("abc", 26));
//        assertEquals("abc", Strings.ceasarCypherEncryptorAscii("abc", 52));
//        assertEquals("fgh", Strings.ceasarCypherEncryptorAscii("abc", 57));
        assertEquals("wxy", Strings.ceasarCypherEncryptorAscii("xyz", 25));
        assertEquals("hvtepmjpjpnnkwyykyhgpel", Strings.ceasarCypherEncryptorAscii("iwufqnkqkqoolxzzlzihqfm", 25));
        assertEquals("tcrshocqjuidxcabatmhmrdpbhnqrgtgdnm", Strings.ceasarCypherEncryptorAscii("mvklahvjcnbwqvtutmfafkwiuagjkzmzwgf", 7));
//        assertEquals("ovmqkwtujqmfkao", Strings.ceasarCypherEncryptorAscii("ovmqkwtujqmfkao", 52));
        assertEquals("zylbcipjkyycbhpvlvplzpvujpjvywplvcplvywplyvplquplvwthw", Strings.ceasarCypherEncryptorAscii("kjwmntauvjjnmsagwgawkagfuaugjhawgnawgjhawjgawbfawghesh", 15));
    }
}
