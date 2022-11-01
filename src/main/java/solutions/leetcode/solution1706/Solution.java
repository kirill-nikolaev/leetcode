package solutions.leetcode.solution1706;

public class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid[0].length;

        int[] ballsPos = new int[n];

        for (int i = 0; i < n; i++) {
            ballsPos[i] = i;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < n; j++) {
                int k;
                if ((k = ballsPos[j]) != -1) {
                    int d = grid[i][k] + k;
                    if (d >= 0 && d < n && grid[i][k] == grid[i][d])
                        ballsPos[j] += grid[i][k];
                    else
                        ballsPos[j] = - 1;
                }
            }
        }
        return ballsPos;
    }
}
