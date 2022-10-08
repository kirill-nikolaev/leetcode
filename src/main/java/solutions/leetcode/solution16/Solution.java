package solutions.leetcode.solution16;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int twoSumResult = twoSumClosest(nums, target - nums[i], i + 1);
            if (Math.abs(target - result) > Math.abs(target - twoSumResult - nums[i])) {
                result = twoSumResult + nums[i];
            }
        }

        return result;
    }

    private int twoSumClosest(int[] nums, int target, int from) {
        int left = from;
        int right = nums.length - 1;

        int result = nums[left] + nums[right];
        int currentSum;

        while (left < right) {
            currentSum = nums[left] + nums[right];

            if (currentSum < target)
                left++;
            else
                right--;

            if (Math.abs(currentSum - target) < Math.abs(result - target)) {
                result = currentSum;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }
}
