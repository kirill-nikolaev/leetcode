package solutions.leetcode.solution1544;

public class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean hasChanges = true;

        while (hasChanges) {
            hasChanges = false;
            int index = 0;
            while (index + 1 < sb.length()) {
                if (Character.toUpperCase(sb.charAt(index + 1)) == Character.toUpperCase(sb.charAt(index)) &&
                        sb.charAt(index + 1) != sb.charAt(index)) {
                    sb.deleteCharAt(index + 1);
                    sb.deleteCharAt(index);
                    hasChanges = true;
                } else {
                    index++;
                }
            }
        }

        return sb.toString();
    }
}
