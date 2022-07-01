package solutions.leetcode.solution81;

public class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        if (nums.length == 1) return nums[0] == target;

        while (start < end) {
            mid = (start + end) / 2;
            if (nums[mid] == target || nums[start] == target || nums[end] == target) return true;

            if (nums[start] == nums[mid]) {
                if (nums[mid] == nums[start]) {
                    start++;
                    end--;
                } else
                    start = mid + 1;
            } else if (nums[mid] == nums[end]) {
                end = mid - 1;
            } else if (nums[mid] > nums[start]) {

                if (target > nums[start] && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;

            } else {
                if (target < nums[start] && target > nums[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return false;
    }
}
