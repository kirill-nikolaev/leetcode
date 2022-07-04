package solutions.leetcode.solution376;

import java.util.Stack;

public class Solution {
    public int wiggleMaxLength(int[] nums) {

        return Math.max(getWiggleSize(nums, true), getWiggleSize(nums, false));
    }

    int getWiggleSize(int[] nums, boolean nextNumberIsLarger) {
        Stack<Integer> wiggleSequence = new Stack<>();

        wiggleSequence.push(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == wiggleSequence.peek())
                continue;

            if (nums[i] > wiggleSequence.peek() == nextNumberIsLarger) {
                wiggleSequence.push(nums[i]);
                nextNumberIsLarger = !nextNumberIsLarger;
            } else {
                wiggleSequence.pop();
                wiggleSequence.push(nums[i]);
            }
        }

        return wiggleSequence.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wiggleMaxLength(new int[]{1,7,4,9,2,5}));
        System.out.println(solution.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(solution.wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(solution.wiggleMaxLength(new int[]{0, 0}));
    }
}
