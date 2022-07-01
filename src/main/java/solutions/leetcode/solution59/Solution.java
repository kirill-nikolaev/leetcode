package solutions.leetcode.solution59;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        matrix[0][0] = 1;
        goRight(0, 0, 2, matrix);

        return matrix;
    }

    private void goRight(int x, int y, int currentNumber, int[][] matrix) {
        if (y + 1 == matrix.length || matrix[x][y + 1] > 0) return;

        while (y + 1 < matrix.length && matrix[x][y + 1] == 0) {
            y++;
            matrix[x][y] = currentNumber;
            currentNumber++;
        }
        goDown(x, y, currentNumber, matrix);
    }

    private void goDown(int x, int y, int currentNumber, int[][] matrix) {
        if (matrix[x + 1][y] > 0) return;
        while (x + 1 < matrix.length && matrix[x + 1][y] == 0) {
            x++;
            matrix[x][y] = currentNumber;
            currentNumber++;
        }
        goLeft(x, y, currentNumber, matrix);
    }

    private void goLeft(int x, int y, int currentNumber, int[][] matrix) {
        if (matrix[x][y - 1] > 0) return;

        while (y > 0 && matrix[x][y - 1] == 0) {
            y--;
            matrix[x][y] = currentNumber;
            currentNumber++;
        }
        goUp(x, y, currentNumber, matrix);
    }

    private void goUp(int x, int y, int currentNumber, int[][] matrix) {
        if (matrix[x - 1][y] > 0) return;

        while (matrix[x - 1][y] == 0) {
            x--;
            matrix[x][y] = currentNumber;
            currentNumber++;
        }
        goRight(x, y, currentNumber, matrix);
    }
}
