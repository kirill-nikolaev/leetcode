package solutions.leetcode.solution216;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> result;
    private Integer[] combination;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        combination = new Integer[k];
        findCombination(n, 0, 0);

        return result;
    }

    private void findCombination(int requiredSum, int index, int currentSum) {
        if (index == combination.length) {
            if (currentSum == requiredSum)
                result.add(List.of(combination));
            return;
        }

        int min = 1;
        if (index > 0)
            min = combination[index - 1] + 1;

        for (int i = min; i <= 9; i++) {
            if (requiredSum >= currentSum + i) {
                combination[index] = i;
                findCombination(requiredSum, index + 1, currentSum + i);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum3(3, 9));
    }
}
