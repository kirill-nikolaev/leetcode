package solutions.leetcode.solution2161;

public class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] array = new int[nums.length];
        int firstCount = 0;
        int secondCount = array.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                array[firstCount] = nums[i];
                firstCount++;
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (nums[i] > pivot) {
                array[secondCount] = nums[i];
                secondCount--;
            }
        }
        for (int i = firstCount; i <= secondCount; i++) {
            array[i] = pivot;
        }
        return array;
    }
}
