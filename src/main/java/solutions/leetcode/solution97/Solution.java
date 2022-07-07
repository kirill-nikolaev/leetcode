package solutions.leetcode.solution97;

// 99 / 106 test cases passed.

public class Solution {
    public boolean isInterleave(String firstString, String secondString, String thirdString) {
        if (firstString.length() + secondString.length() != thirdString.length())
            return false;

        if (firstString.length() == 0 && secondString.equals(thirdString))
            return true;
        if (secondString.length() == 0 && firstString.equals(thirdString))
            return true;

        return checkOnInterleaving(firstString, 0, secondString, 0, thirdString);
    }

    private boolean checkOnInterleaving(String firstString, int firstPos, String secondString, int secondPos, String thirdString) {
        if (firstPos == firstString.length()) {
            for (int i = secondPos; i < secondString.length(); i++) {
                if (secondString.charAt(i) != thirdString.charAt(i + firstPos))
                    return false;
            }
            return true;
        }

        if (secondPos == secondString.length()) {
            for (int i = firstPos; i < firstString.length(); i++) {
                if (firstString.charAt(i) != thirdString.charAt(i + secondPos))
                    return false;
            }
            return true;
        }

        if (firstString.charAt(firstPos) == thirdString.charAt(firstPos + secondPos)) {
            if (checkOnInterleaving(firstString, firstPos + 1, secondString, secondPos, thirdString))
                return true;
        }

        if (secondString.charAt(secondPos) == thirdString.charAt(firstPos + secondPos)) {
            if (checkOnInterleaving(firstString, firstPos, secondString, secondPos + 1, thirdString))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
    }

}
