package solutions.leetcode.solution69;

public class Solution {
    public int mySqrt(int x) {
        if (x < 2)
            return x;
        int right = x;
        int left = 1;
        int current = x / 2;
        long square;
        while (left + 1 < right) {
            square = (long) current * current;
            if (square > x) {
                right = current;
            } else if (square < x) {
                left = current;
            } else
                return current;
            current = (left + right) / 2;
        }
        return current;
    }
}
