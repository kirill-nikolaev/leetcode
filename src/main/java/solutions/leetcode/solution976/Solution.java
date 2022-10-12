package solutions.leetcode.solution976;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2])
                return nums[i] + nums[i - 1] + nums[i - 2];
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestPerimeter(new int[]{2,1,2}));
        System.out.println(solution.largestPerimeter(new int[]{1,2,1}));
    }
}
