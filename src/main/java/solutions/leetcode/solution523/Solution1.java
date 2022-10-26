package solutions.leetcode.solution523;

import java.util.HashSet;

public class Solution1 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2)
            return false;

        HashSet<Integer> moduloSet = new HashSet<>();
        boolean b = false;
        int currentModulo = 0;

        if (nums[0] % k == 0)
            b = true;
        else {
            moduloSet.add(nums[0] % k);
            currentModulo = nums[0] % k;
        }

        for (int i = 1; i < nums.length; i++) {
            int modulo = nums[i] % k;

            if (modulo == 0) {
                if (b)
                    return true;
                b = true;
            } else {
                b = false;
                currentModulo = (currentModulo + modulo) % k;

                if (currentModulo == 0)
                    return true;
                if (moduloSet.contains(currentModulo))
                    return true;

                moduloSet.add(currentModulo);
            }
        }
        return false;
    }
}
