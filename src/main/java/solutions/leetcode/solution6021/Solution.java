package solutions.leetcode.solution6021;

public class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        char first = pattern.charAt(0);
        char second = pattern.charAt(1);
        int firstNumber = 0;
        int secondNumber = 0;
        long summary = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == first) {
                firstNumber++;
            } else if (text.charAt(i) == second) {
                secondNumber++;
                summary += firstNumber;
            }
        }
        if (first == second)
            return ((long) firstNumber * (firstNumber + 1)) / 2;
        return summary + Math.max(firstNumber, secondNumber);
    }
}
