package solutions.leetcode.solution410;

public class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] arr = new int[n];
        int sum = 0;

        for (int i = 0; i <= n - m; i++) {
            sum += nums[i];
            arr[i] = sum;
        }

        for (int i = 1; i < m; i++) {
            for (int j = n - m + i; j >= i; j--) {
                sum = 0;
                arr[j] = arr[j - 1];
                for (int k = j; k >= i; k--) {
                    sum += nums[k];
                    if (sum > arr[k - 1]) {
                        if (j == k)
                            arr[j] = sum;
                        else
                            arr[j] = Math.min(sum, arr[k]);
                        break;
                    }
                    if (k == i)
                        arr[j] = Math.max(sum, arr[i - 1]);
                }
                if (j == n - 1)
                    return arr[n - 1];
            }
        }
        return arr[n - 1];
    }
}
