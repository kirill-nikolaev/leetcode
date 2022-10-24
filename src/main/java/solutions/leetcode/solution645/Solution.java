package solutions.leetcode.solution645;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] checkNums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            checkNums[nums[i]]++;
        }

        int first = 0;
        int second = 0;
        for (int i = 1; i < checkNums.length; i++) {
            if (checkNums[i] == 2)
                first = i;
            if (checkNums[i] == 0)
                second = i;
        }
        return new int[]{first, second};
    }
}
