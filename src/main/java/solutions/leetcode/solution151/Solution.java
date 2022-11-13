package solutions.leetcode.solution151;

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split(" +");

        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0 ; i--) {
            result.append(words[i]).append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
