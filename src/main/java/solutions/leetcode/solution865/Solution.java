package solutions.leetcode.solution865;

public class Solution {
    public int scoreOfParentheses(String s) {

        int result = getScore(s, 0, s.length() - 1);

        return result;
    }

    private int getPair(String s, int index) {
        int count = 1;
        while (count > 0) {
            index++;
            if (s.charAt(index) == '(')
                count++;
            else
                count--;
        }
        return index;
    }

    private int getScore(String s, int first, int last) {

        int end = getPair(s, first);
        int score;
        if (end - first == 1)
            score = 1;
        else
            score = 2 * getScore(s, first + 1, end - 1);

        if (end != last)
            score += getScore(s, end + 1, last);

        return score;
    }
}
