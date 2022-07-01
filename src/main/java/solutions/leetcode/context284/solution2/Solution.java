package solutions.leetcode.context284.solution2;

import java.util.HashSet;

public class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        HashSet<Integer> hashSet = new HashSet<>();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < artifacts.length; i++) {
            for (int j = artifacts[i][0]; j <= artifacts[i][2]; j++) {
                for (int k = artifacts[i][1]; k <= artifacts[i][3]; k++) {
                    matrix[j][k] = i + 1;
                }
            }
        }
        for (int i = 0; i < dig.length; i++) {
            matrix[dig[i][0]][dig[i][1]] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0) {
                    hashSet.add(matrix[i][j]);
                }
            }
        }
        return artifacts.length - hashSet.size();
    }
}
