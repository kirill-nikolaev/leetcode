package solutions.leetcode.solution732;

import java.util.TreeMap;

// решение проще, но на порядок медленнее
public class MyCalendarThree1 {
    private final TreeMap<Integer, Integer> treeMap;
    private int max;

    public MyCalendarThree1() {
        treeMap = new TreeMap<>();
    }

    public int book(int start, int end) {
        treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
        treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);

        int k = 0;
        for (Integer value: treeMap.values()) {
            k = k + value;
            max = Math.max(k, max);
        }

        return max;
    }
}
