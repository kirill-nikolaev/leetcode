package solutions.leetcode.solution334;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = nums[0];
        boolean midIsFound = false;
        int mid = 0;


        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= min)
                min = nums[i];
            else if (midIsFound) {
                if (nums[i] <= mid)
                    mid = nums[i];
                else
                    return true;
            } else {
                midIsFound = true;
                mid = nums[i];
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println(solution.increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println(solution.increasingTriplet(new int[]{2,1,5,0,4,6}));
    }
}
