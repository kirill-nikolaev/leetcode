package solutions.leetcode.solution263;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void Test1() {
        Solution solution = new Solution();
        assertTrue(solution.isUgly(6));
    }

    @Test
    void Test2() {
        Solution solution = new Solution();
        assertTrue(solution.isUgly(1));
    }

    @Test
    void Test3() {
        Solution solution = new Solution();
        assertFalse(solution.isUgly(14));
    }

    @Test
    void Test4() {
        Solution solution = new Solution();
        assertFalse(solution.isUgly(0));
    }
}