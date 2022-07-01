package solutions.leetcode.solution74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int first = 0;
        int last = matrix.length - 1;
        int current;
        while (first < last) {
            current = (first + last + 1) / 2;
            if (matrix[current][0] == target) return true;

            if (matrix[current][0] > target)
                last = current - 1;
            else
                first = current;
        }
        if (last < 0) return false;

        int row = last;
        first = 0;
        last = matrix[row].length - 1;

        while (first <= last) {
            current = (first + last) / 2;
            if (matrix[row][current] == target) return true;

            if (matrix[row][current] > target)
                last = current - 1;
            else
                first = current + 1;
        }
        return false;
    }
}
