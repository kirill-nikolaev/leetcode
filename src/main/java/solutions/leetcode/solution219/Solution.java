package solutions.leetcode.solution219;

import java.util.HashSet;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0)
            return false;

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k)
                hashSet.remove(nums[i - k - 1]);
                if (hashSet.contains(nums[i]))
                    return true;
            hashSet.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(solution.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
        System.out.println(solution.containsNearbyDuplicate(new int[]{1}, 1));
    }
}
