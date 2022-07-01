package solutions.leetcode.solution1359;

public class Solution {
    public int countOrders(int n) {
        long result = 1;

        for (int i = 1; i < n; i++) {
            result = result * (i + 1) * (2L * i + 1);
            result %= 1_000_000_007;
        }

        return (int) result;
    }
}
