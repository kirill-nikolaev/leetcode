package solutions.leetcode.solution835;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void Test1() {
        int[][] img1 = {{1,1,0},{0,1,0},{0,1,0}};
        int[][] img2 = {{0,0,0},{0,1,1},{0,0,1}};

        assertEquals(new Solution().largestOverlap(img1, img2), 3);
    }

    @Test
    void Test2() {
        assertEquals(new Solution().largestOverlap(new int[][]{{1}}, new int[][]{{1}}), 1);
    }

    @Test
    void Test3() {
        assertEquals(new Solution().largestOverlap(new int[][]{{0}}, new int[][]{{0}}), 0);
    }

    @Test
    void Test4() {
        assertEquals(new Solution().largestOverlap(new int[][]{{0,1,1,1},{0,1,1,1},{0,1,1,1},{0,0,0,0}},
                new int[][]{{0,0,0,0},{1,1,1,0},{1,1,1,0},{1,1,1,0}}), 9);
    }
}