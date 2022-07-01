package solutions.leetcode.solution85;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxRectangle = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    maxRectangle = getMaxRectangle(i, j, matrix, maxRectangle);
                }
            }
        }

        return maxRectangle;
    }


    private int getMaxRectangle(int x, int y, char[][] matrix, int max) {

        if ((matrix.length - x) * (matrix[0].length - y) < max)
            return max;
        int currentMax = 0;
        int currentX = x;
        int currentY;
        int prevY = matrix[0].length;
        while ((currentX < matrix.length) && (matrix[currentX][y] == '1')) {
            currentY = y;
            while ((currentY < prevY) && (matrix[currentX][currentY] == '1')) {
                currentY++;
            }

            prevY = currentY;

            int maxPossibleRectangle = (matrix.length - x) * (prevY - y);
            if (maxPossibleRectangle < max || maxPossibleRectangle < currentMax)
                break;

            currentX++;
            currentMax = Math.max((prevY - y) * (currentX - x), currentMax);
        }

        return Math.max(max, currentMax);
    }
}
