package solutions.leetcode.solution47;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    private List<List<Integer>> result;
    private List<Integer> currentPermutation;
    private List<Integer> uniqueNumber;
    private HashMap<Integer, Integer> numbers;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        currentPermutation = new ArrayList<>();
        numbers = new HashMap<>();
        uniqueNumber = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!numbers.containsKey(nums[i]))
                uniqueNumber.add(nums[i]);
            numbers.put(nums[i], numbers.getOrDefault(nums[i], 0) + 1);
        }

        getPermutation(nums.length);
        return result;
    }

    private void getPermutation(int count) {
        if (count == 0) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }
        int value;

        for (Integer x: uniqueNumber) {
            if ((value = numbers.get(x)) > 0) {
                numbers.put(x, value - 1);
                currentPermutation.add(x);
                getPermutation(count - 1);
                currentPermutation.remove(currentPermutation.size() - 1);
                numbers.put(x, value);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[]{1,2,3}));
        System.out.println(solution.permuteUnique(new int[]{1,1,2}));
    }
}
