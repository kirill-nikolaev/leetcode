package solutions.leetcode.solution740;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        int min = 10000;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
            if (nums[i] > max)
                max = nums[i];
        }

        int sumsLength = max - min + 1;

        if (sumsLength == 1)
            return nums.length * nums[0];


        int[] sums = new int[sumsLength];

        for (int i = 0; i < nums.length; i++) {
            sums[nums[i] - min] += nums[i];
        }

        int[] maxSums = new int[sumsLength];
        maxSums[0] = 0;
        maxSums[1] = sums[0];

        for (int i = 2; i < sumsLength; i++) {
            maxSums[i] = Math.max(maxSums[i - 1], maxSums[i - 2] + sums[i - 1]);
        }

        return Math.max(maxSums[sumsLength - 1], maxSums[sumsLength - 2] + sums[sumsLength - 1]);
    }
}
