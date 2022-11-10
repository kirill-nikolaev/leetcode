package solutions.leetcode.solution1047;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void Test1() {
        Solution solution = new Solution();

        assertEquals("ca", solution.removeDuplicates("abbaca"));
    }

    @Test
    void Test2() {
        Solution solution = new Solution();

        assertEquals("ay", solution.removeDuplicates("azxxzy"));
    }
}