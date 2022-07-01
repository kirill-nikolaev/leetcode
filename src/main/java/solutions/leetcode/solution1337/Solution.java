package solutions.leetcode.solution1337;

import java.util.Arrays;

public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        RowStrength[] rowStrengths = new RowStrength[mat.length];
        for (int i = 0; i < mat.length; i++) {
            rowStrengths[i] = new RowStrength();
            rowStrengths[i].row = i;
            for (int j = 0; j < mat[i].length; j++) {
                rowStrengths[i].strength += mat[i][j];
            }
        }
        Arrays.sort(rowStrengths, (x, y) -> x.strength - y.strength);
        for (int i = 0; i < k; i++) {
            result[i] = rowStrengths[i].row;
        }
        return  result;
    }

    private class RowStrength {
        int row;
        int strength;
    }
}
