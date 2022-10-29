package solutions.leetcode.solution2136;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void Test1() {
        Solution solution = new Solution();
        assertEquals(9, solution.earliestFullBloom(new int[]{1,4,3}, new int[]{2,3,1}));
    }

    @Test
    void Test2() {
        Solution solution = new Solution();
        assertEquals(9, solution.earliestFullBloom(new int[]{1,2,3,2}, new int[]{2,1,2,1}));
    }
}