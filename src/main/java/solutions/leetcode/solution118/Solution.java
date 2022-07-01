package solutions.leetcode.solution118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        pascalTriangle.add(new ArrayList<>());
        pascalTriangle.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> pascalRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    pascalRow.add(1);
                else
                    pascalRow.add(pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j));

            }
            pascalTriangle.add(pascalRow);
        }
        return pascalTriangle;
    }
}
