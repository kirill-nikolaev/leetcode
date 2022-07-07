package solutions.leetcode.solution97;

public class Solution2 {
    public boolean isInterleave(String firstString, String secondString, String thirdString) {
        if (firstString.length() == 0)
            return secondString.equals(thirdString);

        if (secondString.length() == 0)
            return firstString.equals(thirdString);

        if (secondString.length() + firstString.length() != thirdString.length())
            return false;

        int n = firstString.length() + 1;
        int m = secondString.length() + 1;
        boolean[] array = new boolean[m];
        array[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (j != 0) {
                    if (array[j - 1] && secondString.charAt(j - 1) == thirdString.charAt(i + j - 1)) {
                        array[j] = true;
                        continue;
                    }
                }
                if (array[j] && firstString.charAt(i - 1) != thirdString.charAt(i + j - 1))
                    array[j] = false;
            }
        }
        return array[m - 1];
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(solution2.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
    }
}
