package solutions.leetcode.solution17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> result;
    private char[] currentCombination;
    private char[][] allLetters;

    {
        result = new ArrayList<>();
        allLetters = new char[][]{
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return result;

        currentCombination = new char[digits.length()];
        createString(digits, 0);
        return result;
    }

    private void createString(String digits, int usedDigits) {
        if (usedDigits == digits.length()) {
            result.add(new String(currentCombination));
            return;
        }

        int x = digits.charAt(usedDigits) - '2';
        for (int i = 0; i < allLetters[x].length; i++) {
            currentCombination[usedDigits] = allLetters[x][i];
            createString(digits, usedDigits + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("22"));
    }
}
