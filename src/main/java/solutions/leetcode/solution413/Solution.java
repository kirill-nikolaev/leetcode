package solutions.leetcode.solution413;

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int answer = 0;
        int length = nums.length;
        int count = 0;
        int sum = 0;


        for (int i = 0; i < length - 2; i++) {

            if (nums[i] - nums[i + 1] == nums[i + 1] - nums[i + 2]) {
                count++;
                sum += count;
            } else {
                answer += sum;
                count = 0;
                sum = 0;
            }

        }

        answer += sum;


        return answer;
    }
}
