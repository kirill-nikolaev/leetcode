package solutions.leetcode.solution97;

public class Solution1 {
    public boolean isInterleave(String firstString, String secondString, String thirdString) {
        if (firstString.length() == 0)
            return secondString.equals(thirdString);

        if (secondString.length() == 0)
            return firstString.equals(thirdString);

        if (secondString.length() + firstString.length() != thirdString.length())
            return false;

        int n = firstString.length() + 1;
        int m = secondString.length() + 1;
        boolean[][] array = new boolean[n][m];
        array[0][0] = true;

        for (int i = 0; i < secondString.length(); i++) {
            if (array[0][i] && thirdString.charAt(i) == secondString.charAt(i))
                array[0][i + 1] = true;
        }

        for (int i = 0; i < firstString.length(); i++) {
            if (array[i][0] && thirdString.charAt(i) == firstString.charAt(i))
                array[i + 1][0] = true;
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (array[i][j - 1] && secondString.charAt(j - 1) == thirdString.charAt(i + j - 1))
                    array[i][j] = true;
                else if (array[i - 1][j] && firstString.charAt(i - 1) == thirdString.charAt(i + j - 1))
                    array[i][j] = true;
            }
        }
        return array[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(solution1.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
    }
}
