package solutions.leetcode.solution6027;

public class Solution {
    public int countHillValley(int[] nums) {
        boolean isHill = false;
        boolean isValley = false;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i] ) {
                if (isHill) {
                    count++;
                    isHill = false;
                }
                isValley = true;
            }
            else if (nums[i - 1] < nums[i]) {
                if (isValley) {
                    count++;
                    isValley = false;
                }
                isHill = true;
            }
        }
        return count;
    }
}
