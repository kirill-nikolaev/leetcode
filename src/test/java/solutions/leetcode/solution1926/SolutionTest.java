package solutions.leetcode.solution1926;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void Test1() {
        Solution solution = new Solution();
        assertEquals(1, solution.nearestExit(new char[][]{{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}}, new int[]{1, 2}));
    }

    @Test
    void Test2() {
        Solution solution = new Solution();
        assertEquals(2, solution.nearestExit(new char[][]{{'+','+','+'},{'.','.','.'},{'+','+','+'}}, new int[]{1, 0}));
    }

    @Test
    void Test3() {
        Solution solution = new Solution();
        assertEquals(-1, solution.nearestExit(new char[][]{{'.','+'}}, new int[]{0, 0}));
    }
}