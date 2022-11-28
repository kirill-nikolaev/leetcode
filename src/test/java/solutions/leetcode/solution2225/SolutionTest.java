package solutions.leetcode.solution2225;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void Test1() {
        Solution solution = new Solution();
        List<List<Integer>> excepted = new ArrayList<>();

        excepted.add(List.of(1, 2, 10));
        excepted.add(List.of(4, 5, 7, 8));

        assertEquals(excepted, solution.findWinners(new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}}));
    }


    @Test
    void Test2() {
        Solution solution = new Solution();
        List<List<Integer>> excepted = new ArrayList<>();

        excepted.add(List.of(1, 2, 5, 6));
        excepted.add(Collections.EMPTY_LIST);

        assertEquals(excepted, solution.findWinners(new int[][]{{2,3},{1,3},{5,4},{6,4}}));
    }
}