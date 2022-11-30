package solutions.leetcode.solution1207;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i: arr)
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);

        HashSet<Integer> hashSet = new HashSet<>(hashMap.values());

        return hashSet.size() == hashMap.size();
    }
}
