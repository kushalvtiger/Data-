package kushal.practice.problems.algoexpert.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AngelTest
{

    @Test
    void test()
    {
        assertEquals(0, Angel.firstNonRepeatingString("leetcode"));
        assertEquals(2, Angel.firstNonRepeatingString("loveleetcode"));
        assertEquals(-1, Angel.firstNonRepeatingString("aabb"));
        
        assertEquals("LXXIV", Angel.intToRoman(74));
    }

}
