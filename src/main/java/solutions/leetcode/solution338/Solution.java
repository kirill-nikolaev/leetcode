package solutions.leetcode.solution338;

public class Solution {
    public int[] countBits(int n) {
        int[] numbers = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            numbers[i] = getNumberOfBits(i);
        }
        return numbers;
    }


    private int getNumberOfBits(int n) {
        int numberOfBits = 0;
        while (n > 0) {
            numberOfBits += n & 1;
            n >>= 1;
        }
        return numberOfBits;
    }
}
