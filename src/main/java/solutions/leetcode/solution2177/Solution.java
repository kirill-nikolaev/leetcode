package solutions.leetcode.solution2177;

public class Solution {
    public long[] sumOfThree(long num) {
        if (num % 3 != 0)
            return new long[0];

        else {
            long[] numbers = new long[3];

            numbers[0] = num / 3 - 1;
            numbers[1] = num / 3;
            numbers[2] = num / 3 + 1;

            return numbers;
        }
    }
}
