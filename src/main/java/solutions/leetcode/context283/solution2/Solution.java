package solutions.leetcode.context283.solution2;

import java.util.Arrays;

public class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long sum;


        if (nums[0] > k) {
            sum = (long) (1 + k) * k / 2;
            return sum;
        } else {
            sum = (long) nums[0] * (nums[0] - 1) / 2;
        }
        k = k - nums[0] + 1;

        for (int i = 0; i < nums.length - 1; i++) {

            int delta = nums[i + 1] - nums[i] - 1;
            if (delta <= 0)
                continue;
            if (delta < k) {
                sum = sum +  ((long) nums[i + 1] + nums[i]) * (delta) / 2;
                k = k - delta;
            } else {
                sum = sum +  ((long) nums[i] * 2 + k + 1) * k / 2;
                return sum;
            }

        }

        sum = sum +  ((long) nums[nums.length - 1] * 2 + k + 1) * k / 2;

        return sum;
    }
}
