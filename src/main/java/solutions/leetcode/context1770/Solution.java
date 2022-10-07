package solutions.leetcode.context1770;

class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        int n = nums.length;
        int[][] score = new int[m + 1][m + 1];

        for (int i = 0; i < m; i++) {
            score[0][i + 1] = score[0][i] + nums[n - 1 - i] * multipliers[i];
        }

        for (int i = 0; i < m; i++) {
            score[i + 1][i + 1] = score[i][i] + nums[i] * multipliers[i];
        }

        for (int i = 2; i <= m ; i++) {
            for (int j = 1; j < i; j++) {
                score[j][i] = Math.max(score[j - 1][i - 1] + nums[j - 1] * multipliers[i - 1],
                        score[j][i - 1] + nums[n - i + j] * multipliers[i - 1]);
            }
        }

        int result = score[0][m];
        for (int i = 1; i <= m; i++) {
            result = Math.max(result, score[i][m]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumScore(new int[]{1,2,3}, new int[]{3,2,1}));
        System.out.println(solution.maximumScore(new int[]{-5,-3,-3,-2,7,1}, new int[]{-10,-5,3,4,6}));
    }
}
