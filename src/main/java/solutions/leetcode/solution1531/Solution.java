package solutions.leetcode.solution1531;


public class Solution {
    public int getLengthOfOptimalCompression(String str, int k) {
        int length = str.length();
        int[] charRepeat = new int[length];
        charRepeat[0] = 1;
        for (int i = 1; i < length; i++) {
            if (str.charAt(i) == str.charAt(i - 1))
                charRepeat[i] = charRepeat[i - 1] + 1;
            else
                charRepeat[i] = 1;
        }

        int[][] dp = new int[k + 1][length + 1];

        for (int j = 1; j <= length; j++) {
            dp[0][j] = dp[0][j - charRepeat[j - 1]] + repeatLength(charRepeat[j - 1]);
        }

        for (int i = 1; i <= k; i++) {
            for (int j = i + 1; j <= length; j++) {
                dp[i][j] = dp[i - 1][j - 1];
                int sameChar = 0;
                int anotherChar = 0;
                for (int l = j; l >= 1; l--) {
                    if (str.charAt(j - 1) == str.charAt(l - 1))
                        sameChar++;
                    else
                        anotherChar++;

                    if (anotherChar > i)
                        break;

                    dp[i][j] = Math.min(dp[i - anotherChar][j - sameChar - anotherChar] + repeatLength(sameChar), dp[i][j]);

                }
            }
        }

        return dp[k][length];
    }

    private int repeatLength(int i) {
        if (i == 1) return 1;
        if (i < 10) return 2;
        if (i < 100) return 3;
        return 4;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getLengthOfOptimalCompression("aabbaa", 2));
        System.out.println(solution.getLengthOfOptimalCompression("aaabcccd", 2));
    }
}
