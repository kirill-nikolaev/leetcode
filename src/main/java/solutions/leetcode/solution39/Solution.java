package solutions.leetcode.solution39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> lists = new ArrayList<>();
    private ArrayList<Integer> combination = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        lists.clear();
        combination.clear();
        findCombination(candidates, 0, target, 0);
        return lists;
    }

    private void findCombination(int[] candidates, int sum, int target, int currentCandidate) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            lists.add(new ArrayList<>(combination));
            return;
        }
        for (int i = currentCandidate; i < candidates.length; i++) {
            combination.add(candidates[i]);
            findCombination(candidates, sum + candidates[i], target, i);
            combination.remove(combination.size() - 1);
        }
    }
}
