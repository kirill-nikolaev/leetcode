package solutions.leetcode.context284.solution3;

public class Solution {
    public int maximumTop(int[] nums, int k) {
        if (nums.length == 1) {
            if (k % 2 == 0)
                return nums[0];
            else {
                return -1;
            }
        }
        if (k == 1)
            return nums[1];
        k = k - 1;

        int max = 0;
        if (k > nums.length) {
            k = nums.length;
        }

        if (k + 1 < nums.length) {
            max = nums[k + 1];
        }
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
