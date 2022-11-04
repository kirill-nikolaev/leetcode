package solutions.leetcode.solution345;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void Test1 () {
        Solution solution = new Solution();

        assertEquals("holle", solution.reverseVowels("hello"));
    }

    @Test
    void Test2 () {
        Solution solution = new Solution();

        assertEquals("leotcede", solution.reverseVowels("leetcode"));
    }


}