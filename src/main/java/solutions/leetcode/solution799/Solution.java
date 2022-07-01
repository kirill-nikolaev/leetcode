package solutions.leetcode.solution799;

public class Solution {
    public double champagneTower(int poured, int queryRow, int queryGlass) {
        double[] row = new double[queryRow + 1];
        row[0] = poured;
        boolean isChanged;
        for (int i = 1; i <= queryRow; i++) {
            isChanged = false;
            for (int j = i; j >= 0; j--) {

                if (j == 0) {
                    row[0] = (row[0] - 1) / 2;

                    if (row[0] < 0) {
                        row[0] = 0;
                    } else {
                        isChanged = true;
                    }
                }

                else if (j == i) {
                    row[j] = (row[j - 1] - 1) / 2;

                    if (row[j] < 0) {
                        row[j] = 0;
                    } else {
                        isChanged = true;
                    }
                }

                else {
                    row[j] = (row[j] - 1) / 2;

                    if (row[j] < 0) {
                        row[j] = 0;
                    }

                    double change = (row[j - 1] - 1) / 2;

                    if (change > 0) {
                        row[j] += change;
                    }

                    if (row[j] > 0) {
                        isChanged = true;
                    }
                }
            }
            if (!isChanged)
                break;
        }
        if (row[queryGlass] >= 1)
            return 1d;
        else
            return row[queryGlass];
    }
}
