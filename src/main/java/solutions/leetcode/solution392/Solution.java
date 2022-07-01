package solutions.leetcode.solution392;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true;
        }
        int current = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(current)) {
                current++;
                if (current == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
