package solutions.leetcode.solution119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] pascalRow = new int[rowIndex + 1];
        pascalRow[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            pascalRow[i] = 1;
            for (int j = i - 1; j > 0; j--) {
                pascalRow[j] = pascalRow[j - 1] + pascalRow[j];
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            list.add(pascalRow[i]);
        }

        return list;
    }
}
