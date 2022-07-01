package solutions.leetcode.context284.solution1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int first = i - k;
                int second = i + k;
                if (first < index) {
                    first = index;
                }
                if (second >= nums.length) {
                    second = nums.length - 1;
                }
                for (int j = first; j <= second ; j++) {
                    list.add(j);
                }
                index = second + 1;
            }
        }
        return list;
    }
}
