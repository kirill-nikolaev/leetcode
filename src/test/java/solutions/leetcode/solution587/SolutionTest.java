package solutions.leetcode.solution587;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void outerTrees() {
        Solution solutions = new Solution();
        solutions.outerTrees(new int[][]{{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}});
    }

    @Test
    void outerTrees1() {
        Solution solutions = new Solution();
        solutions.outerTrees(new int[][]{{3,3},{2,4},{2,2},{7,4},{3,4}});
    }
    @Test
    void outerTrees2() {
        Solution solutions = new Solution();
        solutions.outerTrees(new int[][]{{0,0},{0,1},{0,2},{1,2},{2,2},{3,2},{3,1},{3,0},{2,0}});
    }
}