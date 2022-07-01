package solutions.leetcode.solution5236;

public class Solution {
    public int minDeletion(int[] nums) {
        int number = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (number % 2 == 1) {
                if (nums[i] != nums[i + 1])
                    number++;
                continue;
            }
            number++;
        }
        if (number % 2 != 0)
            number--;
        return nums.length - number;
    }
}
