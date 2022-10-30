package solutions.leetcode.solution1293;

import java.util.Arrays;

public class Solution {

    private final int val = 10000;
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        if (k >= n + m - 2)
            return n + m - 2;

        int[][][] path = new int[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(path[i][j], val);
            }
        }

        Arrays.fill(path[0][0], 0);

        for (int j = 1; j < m; j++) {
            int start = grid[0][j];

            for (int l = start; l <= k ; l++) {
                if (path[0][j - 1][l - start] != val)
                    path[0][j][l] = path[0][j - 1][l - start] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int start = grid[i][j];

                if (i == 0 && j == 0)
                    continue;

                for (int l = start; l <= k; l++) {
                    if (i == 0) {
                        if (path[0][j - 1][l - start] != val)
                            path[0][j][l] = path[0][j - 1][l - start] + 1;
                        continue;
                    }

                    if (j == 0) {
                        if (path[i - 1][j][l - start] != val)
                            path[i][0][l] = path[i - 1][0][l - start] + 1;
                        continue;
                    }
                    int min = Math.min(path[i - 1][j][l - start], path[i][j - 1][l - start]);
                    if (min != val)
                        path[i][j][l] = min + 1;
                }
            }
        }

        if (path[n - 1][m - 1][k] != val)
            return path[n - 1][m - 1][k];

        boolean hasChanges = true;

        while (hasChanges) {
            hasChanges = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    hasChanges = isHasChanges(grid, k, n, m, path, hasChanges, i, j);
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    hasChanges = isHasChanges(grid, k, n, m, path, hasChanges, i, j);
                }
            }
        }

        if (path[n - 1][m - 1][k] != val)
            return path[n - 1][m - 1][k];

        return -1;
    }

    private boolean isHasChanges(int[][] grid, int k, int n, int m, int[][][] path, boolean hasChanges, int i, int j) {
        int start = grid[i][j];

        if (i == 0 && j == 0)
            return hasChanges;

        for (int l = start; l <= k; l++) {
            int min = val;
            if (i != 0)
                min = path[i - 1][j][l - start];
            if (j != 0)
                min = Math.min(path[i][j - 1][l - start], min);
            if (i != n - 1)
                min = Math.min(path[i + 1][j][l - start], min);
            if (j != m - 1)
                min = Math.min(path[i][j + 1][l - start], min);

            if (min != val && path[i][j][l] != min + 1) {
                hasChanges = true;
                path[i][j][l] = min + 1;
            }
        }
        return hasChanges;
    }
}
