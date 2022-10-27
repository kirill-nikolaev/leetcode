package solutions.leetcode.solution835;

public class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        int max = 0;

        for (int i = -n + 1; i < n; i++) {
            for (int j = -n + 1; j < n; j++) {
                int current = 0;

                int kMin = i >= 0 ? 0 : - i;
                int lMin = j >= 0 ? 0 : - j;
                int kMax = i <= 0 ? n - 1 : n - i - 1;
                int lMax = j <= 0 ? n - 1 : n - j - 1;

                for (int k = kMin; k <= kMax; k++) {
                    for (int l = lMin; l <= lMax; l++) {
                        if (img1[k][l]  == 1) {
                            int x = k + i;
                            int y = l + j;

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
