package solutions.leetcode.solution5268;

import java.util.*;

public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> first = new HashSet<>();
        HashSet<Integer> second = new HashSet<>();
        for (int i = 0; i < nums1.length; i++)
            first.add(nums1[i]);

        for (int i = 0; i < nums2.length; i++)
            second.add(nums2[i]);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for (Integer x: first) {
            if (!second.contains(x))
                result.get(0).add(x);
        }

        for (Integer x: second) {
            if (!first.contains(x))
                result.get(1).add(x);
        }
        return result;
    }
}
