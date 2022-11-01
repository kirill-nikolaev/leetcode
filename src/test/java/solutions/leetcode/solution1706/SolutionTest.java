package solutions.leetcode.solution1706;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void Test1() {
        Solution solution = new Solution();
        int[][] grid = {
                {1,1,1,-1,-1},
                {1,1,1,-1,-1},
                {-1,-1,-1,1,1},
                {1,1,1,1,-1},
                {-1,-1,-1,-1,-1}
        };
        int[] expectation = {1,-1,-1,-1,-1};

        assertArrayEquals(expectation, solution.findBall(grid));
    }

    @Test
    void Test2() {
        Solution solution = new Solution();
        int[][] grid = {
                {1,1,1,1,1,1},
                {-1,-1,-1,-1,-1,-1},
                {1,1,1,1,1,1},
                {-1,-1,-1,-1,-1,-1}
        };
        int[] expectation = {0,1,2,3,4,-1};

        assertArrayEquals(expectation, solution.findBall(grid));
    }

    @Test
    void Test3() {
        Solution solution = new Solution();
        int[][] grid = {
                {-1}
        };
        int[] expectation = {-1};

        assertArrayEquals(expectation, solution.findBall(grid));
    }
}