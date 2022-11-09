package solutions.leetcode.solution1544;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void Test1() {
        Solution solution = new Solution();
        assertEquals("leetcode", solution.makeGood("leEeetcode"));
    }

    @Test
    void Test2() {
        Solution solution = new Solution();
        assertEquals("", solution.makeGood("abBAcC"));
    }

    @Test
    void Test3() {
        Solution solution = new Solution();
        assertEquals("", solution.makeGood("Pp"));
    }
}