package solutions.leetcode.solution835;

public class Solution2 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        int max = 0;

        for (int i = -n + 1; i < n; i++) {
            for (int j = -n + 1; j < n; j++) {
                int current = 0;
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        if (img1[k][l]  == 1) {
                            int x = k + i;
                            int y = l + j;
                            if (x >= 0 && x < n && y >= 0 && y < n)
                                if (img2[x][y] == 1)
                                    current++;
                        }
                    }
                }
                max = Math.max(max, current);
            }
        }
        return max;
    }
}
