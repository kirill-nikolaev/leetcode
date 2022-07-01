package solutions.leetcode.solution6020;

import java.util.HashMap;

public class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key: hashMap.keySet()) {
            if (hashMap.get(key) % 2 != 0)
                return false;
        }
        return true;
    }
}
