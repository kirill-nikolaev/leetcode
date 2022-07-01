package solutions.leetcode.solution6022;

import java.util.TreeMap;

public class Solution {
    public int halveArray(int[] nums) {
        TreeMap<Double, Integer> treeMap = new TreeMap<>();
        double summary = 0;
        for (int i = 0; i < nums.length; i++) {
            treeMap.put((double) nums[i], treeMap.getOrDefault((double) nums[i], 0) + 1);
            summary += nums[i];
        }

        double target = summary / 2;
        int count = 0;

        while (summary > target) {
            count++;
            double key = treeMap.lastKey();
            int value = treeMap.get(key);
            double newKey = key / 2;
            summary = summary - newKey;


            if (value == 1)
                treeMap.remove(key);
            else
                treeMap.put(key, value - 1);
            treeMap.put(newKey, treeMap.getOrDefault(newKey, 0) + 1);
        }
        return count;
    }
}
