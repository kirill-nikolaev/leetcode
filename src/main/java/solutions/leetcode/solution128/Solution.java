package solutions.leetcode.solution128;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();
        HashSet<Integer> firstNumbers = new HashSet<>();
        for (int num: nums) {
            numsSet.add(num);
            firstNumbers.add(num);
        }

        for (Integer num: numsSet) {
            if (numsSet.contains(num - 1)) {
                firstNumbers.remove(num);
            }
        }

        int result = 0;
        for (Integer num: firstNumbers) {
            int current = 0;
            while (numsSet.contains(num)) {
                current++;
                num++;
            }
            result = Math.max(current, result);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(solution.longestConsecutive(new int[]{-3,2,8,5,1,7,-8,2,-8,-4,-1,6,-6,9,6,0,-7,4,5,-4,8,2,0,-2,-6,9,-4,-1}));
        System.out.println(solution.longestConsecutive(new int[]{-7,-1,3,-9,-4,7,-3,2,4,9,4,-9,8,-7,5,-1,-7}));
    }
}
