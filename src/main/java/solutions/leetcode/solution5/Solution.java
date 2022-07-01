package solutions.leetcode.solution5;

public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0; j < length - i; j++) {
                if (checkSubstring(s, j, j + i)) {
                    return s.substring(j, j + i + 1);
                }
            }
        }
        return null;
    }

    private boolean checkSubstring(String s, int first, int last) {
        for (int i = 0; i < (last - first + 1) / 2; i++) {
            if (s.charAt(first + i) != s.charAt(last - i))
                return false;
        }
        return true;
    }
}
