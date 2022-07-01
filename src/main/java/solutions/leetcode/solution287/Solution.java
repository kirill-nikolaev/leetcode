package solutions.leetcode.solution287;

public class Solution {
    public int findDuplicate(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])] < 0) {
                result = Math.abs(nums[i]);
                break;
            }
            nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return result;
    }
}
