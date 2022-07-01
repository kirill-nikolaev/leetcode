package solutions.leetcode.solution1249;

public class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int number = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '(')
                number++;
            else if (stringBuilder.charAt(i) == ')')
                number--;
            if (number < 0) {
                stringBuilder.deleteCharAt(i);
                i--;
                number = 0;
            }
        }
        number = 0;
        for (int i = stringBuilder.length() - 1; i >= 0; i--) {
            if (stringBuilder.charAt(i) == ')')
                number++;
            else if (stringBuilder.charAt(i) == '(')
                number--;
            if (number < 0) {
                stringBuilder.deleteCharAt(i);
                number = 0;
            }
        }
        double a = Math.pow(1, 1);
        return stringBuilder.toString();
    }
}
