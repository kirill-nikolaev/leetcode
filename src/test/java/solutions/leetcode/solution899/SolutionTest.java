package solutions.leetcode.solution899;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void Test1() {
        Solution solution = new Solution();
        assertEquals("acb", solution.orderlyQueue("cba", 1));
    }

    @Test
    void Test2() {
        Solution solution = new Solution();
        assertEquals("aaabc", solution.orderlyQueue("baaca", 3));
    }
}