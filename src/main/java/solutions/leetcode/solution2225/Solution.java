package solutions.leetcode.solution2225;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < matches.length; i++) {
            if (!hashMap.containsKey(matches[i][0]))
                hashMap.put(matches[i][0], 0);
            hashMap.put(matches[i][1], hashMap.getOrDefault(matches[i][1], 0) + 1);
        }

        List<Integer> noLoseList = hashMap.entrySet().stream()
                .filter(x -> x.getValue() == 0)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> oneLoseList = hashMap.entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

        result.add(noLoseList);
        result.add(oneLoseList);

        return result;
    }
}
