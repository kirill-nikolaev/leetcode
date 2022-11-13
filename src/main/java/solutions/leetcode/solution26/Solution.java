package solutions.leetcode.solution26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int currentNumber = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != currentNumber) {
                currentNumber = nums[i];
                nums[k] = currentNumber;
                k++;
            }
        }

        return k;
    }
}
