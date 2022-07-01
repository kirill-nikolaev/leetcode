package solutions.leetcode.solution1029;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        List<List<Integer>> array = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            array.add(List.of(costs[i][0], costs[i][1]));
        }

        array.sort((x, y) -> (x.get(0) - y.get(0)) - (x.get(1) - y.get(1)));

        int result = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            result = result + array.get(i).get(0) + array.get(costs.length - i - 1).get(1);
        }
        return result;
    }
}
