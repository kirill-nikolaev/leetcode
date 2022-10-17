package solutions.leetcode.solution1335;

public class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {

        if (jobDifficulty.length < d)
            return -1;
        int number = jobDifficulty.length;
        int[][] dayDifficulty = new int[number][number + 1];  //difficulty of the day: row - first job,
        //                       column - number of jobs

        for (int i = 0; i < number; i++) {
            dayDifficulty[i][1] = jobDifficulty[i];
        }


        for (int i = 0; i < number; i++) {
            for (int j = 2; j < number + 1 - i; j++) {
                dayDifficulty[i][j] = Math.max(dayDifficulty[i][j - 1], jobDifficulty[i + j - 1]);
            }
        }
        int[][] dp = new int[d][number];  //minimum schedule difficulty doing column jobs in row days


        for (int i = 0; i < number; i++) {
            dp[0][i] = dayDifficulty[0][i + 1];
        }

        for (int i = 1; i < d; i++) {
            for (int j = i; j < number; j++) {
                dp[i][j] = dp[i - 1][i - 1] + dayDifficulty[i][j - i + 1];
                for (int k = i + 1; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k - 1] + dayDifficulty[k][j - k + 1]);
                }
            }
        }
        return dp[d - 1][number - 1];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDifficulty(new int[]{6,5,4,3,2,1}, 2));
        System.out.println(solution.minDifficulty(new int[]{1,1,1}, 3));
        System.out.println(solution.minDifficulty(new int[]{9,9,9}, 4));
    }
}
