package solutions.leetcode.solution2163;

import java.util.TreeMap;

public class Solution {
    public long minimumDifference(int[] nums) {
        TreeMap<Integer, Integer> first = new TreeMap<>();
        TreeMap<Integer, Integer> second = new TreeMap<>();
        int n = nums.length / 3;
        for (int i = 0; i < n; i++) {
            Integer value;
            if ((value = first.get(nums[i])) == null) {
                value = 0;
            }
            first.put(nums[i], value + 1);
        }

        for (int i = 2 * n; i < nums.length; i++) {
            Integer value;
            if ((value = second.get(nums[i])) == null) {
                value = 0;
            }
            second.put(nums[i], value + 1);
        }

        int start = n;
        int finish = 2 * n - 1;
        while (start <= finish) {
            int x = first.lastKey();
            int y = second.firstKey();

            if (x - nums[start] > nums[finish] - y) {
                if (x - nums[start] > 0) {
                    Integer value = first.get(x);
                    if (value == 1)
                        first.remove(x);
                    else
                        first.put(x, value - 1);
                    value = first.get(nums[start]);
                    if (value == null) {
                        value = 0;
                    }
                    first.put(nums[start], value + 1);
                }
                start++;
            } else {
                if (nums[finish] - y > 0) {
                    Integer value = second.get(y);
                    if (value == 1)
                        second.remove(y);
                    else
                        second.put(y, value - 1);
                    value = second.get(nums[finish]);
                    if (value == null) {
                        value = 0;
                    }
                    second.put(nums[finish], value + 1);
                }
                finish--;
            }
        }
        long sum = 0;
        for (Integer key: first.keySet()) {
            sum = sum + (long)key * first.get(key);
        }
        for (Integer key: second.keySet()) {
            sum = sum - (long)key * second.get(key);
        }
        return sum;
    }
}
