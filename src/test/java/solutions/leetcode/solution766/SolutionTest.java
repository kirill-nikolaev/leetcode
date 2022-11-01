package solutions.leetcode.solution766;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void Test1() {
        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        Solution solution = new Solution();
        assertTrue(solution.isToeplitzMatrix(matrix));
    }

    @Test
    void Test2() {
        int[][] matrix = {{1,2}, {2,2}};
        Solution solution = new Solution();
        assertFalse(solution.isToeplitzMatrix(matrix));
    }

    @Test
    void Test3() {
        int[][] matrix = {{18, 64}};
        Solution solution = new Solution();
        assertTrue(solution.isToeplitzMatrix(matrix));
    }
}