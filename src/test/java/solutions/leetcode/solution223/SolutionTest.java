package solutions.leetcode.solution223;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void Test1() {
        Solution solution = new Solution();
        assertEquals(45, solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    @Test
    void Test2() {
        Solution solution = new Solution();
        assertEquals(16, solution.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
    }
}