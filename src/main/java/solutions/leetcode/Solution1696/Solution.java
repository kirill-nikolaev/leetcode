package solutions.leetcode.Solution1696;

import java.util.TreeMap;

public class Solution {
    public int maxResult(int[] nums, int k) {
        int result;
        int[] max = new int[nums.length];
//        Arrays.fill(max, Integer.MIN_VALUE);
//        max[0] = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 1; j <= k; j++) {
//                if (i - j < 0)
//                    break;
//                max[i] = Math.max(max[i], max[i - j]);
//            }
//            max[i] += nums[i];
//        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(nums[0], 1);
        max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = treeMap.lastKey() + nums[i];
            if (i >= k) {
                int temp = treeMap.get(max[i - k]);
                temp--;
                if (temp == 0)
                    treeMap.remove(max[i - k]);
                else
                    treeMap.put(max[i - k], temp);
            }
            treeMap.put(max[i], treeMap.getOrDefault(max[i], 0) + 1);
        }


        result = max[max.length - 1];
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxResult(new int[]{1,-1,-2,4,-7,3}, 2));
        System.out.println(solution.maxResult(new int[]{10,-5,-2,4,0,3}, 3));
        System.out.println(solution.maxResult(new int[]{1,-5,-20,4,-1,3,-6,-3}, 2));
    }
}
