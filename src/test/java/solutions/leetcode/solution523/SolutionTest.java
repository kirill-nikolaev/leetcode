package solutions.leetcode.solution523;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution = new Solution();

    @Test
    void Test1() {
        assertTrue(solution.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
    }

    @Test
    void Test2() {
        assertTrue(solution.checkSubarraySum(new int[]{23,2,6,4,7}, 6));
    }

    @Test
    void Test3() {
        assertFalse(solution.checkSubarraySum(new int[]{23,2,6,4,7}, 13));
    }

    @Test
    void Test4() {
        assertFalse(solution.checkSubarraySum(new int[]{1}, 1));
    }

    @Test
    void Test5() {
        assertTrue(solution.checkSubarraySum(new int[]{5, 0, 0, 0}, 3));
    }

    @Test
    void Test6() {
        assertTrue(solution.checkSubarraySum(new int[]{0, 0}, 25));
    }

    @Test
    void Test7() {
        assertTrue(solution.checkSubarraySum(new int[]{2, 4, 3}, 6));
    }

    @Test
    void Test8() {
        assertFalse(solution.checkSubarraySum(new int[]{1, 0}, 2));
    }
}