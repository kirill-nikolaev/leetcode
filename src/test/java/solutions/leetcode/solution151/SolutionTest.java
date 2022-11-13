package solutions.leetcode.solution151;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void Test1() {
        Solution solution = new Solution();
        assertEquals("example good a" , solution.reverseWords("a good   example"));
    }

    @Test
    void Test2() {
        Solution solution = new Solution();
        assertEquals("world hello" , solution.reverseWords("  hello world  "));
    }

    @Test
    void Test3() {
        Solution solution = new Solution();
        assertEquals("the sky is blue" , solution.reverseWords("blue is sky the"));
    }
}