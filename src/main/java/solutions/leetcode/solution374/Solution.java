package solutions.leetcode.solution374;

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        int answer;
        while ((answer = guess((int) (((long) start + end) / 2))) != 0) {
            if (answer == - 1)
                end =  (int) (((long) start + end) / 2) - 1;
            else
                start = (int) (((long) start + end) / 2) + 1;
        }
        return (int) (((long) start + end) / 2);
    }
}

class GuessGame {
    int guess(int num) {
        return 0;
    }
}