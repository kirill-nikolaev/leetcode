package solutions.leetcode.solution2225;

import java.util.*;

public class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < matches.length; i++) {
            if (!hashMap.containsKey(matches[i][0]))
                hashMap.put(matches[i][0], 0);
            hashMap.put(matches[i][1], hashMap.getOrDefault(matches[i][1], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> mapEntry: hashMap.entrySet()) {
            if (mapEntry.getValue() == 0)
                result.get(0).add(mapEntry.getKey());
            else if (mapEntry.getValue() == 1)
                result.get(1).add(mapEntry.getKey());
        }

        result.get(0).sort(Comparator.naturalOrder());
        result.get(1).sort(Comparator.naturalOrder());

        return result;
    }
}
