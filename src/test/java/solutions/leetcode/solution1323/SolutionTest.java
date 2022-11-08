package solutions.leetcode.solution1323;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void Test1() {
        Solution solution = new Solution();
        assertEquals(9969, solution.maximum69Number(9669));
    }

    @Test
    void Test2() {
        Solution solution = new Solution();
        assertEquals(9996, solution.maximum69Number(9999));
    }

    @Test
    void Test3() {
        Solution solution = new Solution();
        assertEquals(9999, solution.maximum69Number(9996));
    }

}