package solutions.leetcode.solution1323;

public class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder(Integer.toString(num));

        boolean isChanged = false;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '6') {
                sb.setCharAt(i, '9');
                isChanged = true;
                break;
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
