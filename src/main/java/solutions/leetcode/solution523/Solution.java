package solutions.leetcode.solution523;

import java.util.HashMap;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> moduloMap = new HashMap<>();
        moduloMap.put(0, 0);
        int currentModulo = 0;
        for (int i = 0; i < nums.length; i++) {
            currentModulo = (currentModulo + nums[i] % k) % k;

            if (moduloMap.containsKey(currentModulo)) {
                if (moduloMap.get(currentModulo) < i)
                    return true;
                else
                    continue;
            }

            moduloMap.put(currentModulo, i + 1);
        }
        return false;
    }
}
