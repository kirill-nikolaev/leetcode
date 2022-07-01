package solutions.leetcode.solution1710;

import java.util.Arrays;

public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (x, y) -> y[1] - x[1]);

        int result = 0;

        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i][0] > truckSize) {
                result += truckSize * boxTypes[i][1];
                break;
            }
            result += boxTypes[i][0] * boxTypes[i][1];
            truckSize -= boxTypes[i][0];
        }

        return result;

    }

    public static void main(String[] args) {
        Solution solution =  new Solution();
        System.out.println(solution.maximumUnits(new int[][]{{1,3},{2,2},{3,1}}, 4));
        System.out.println(solution.maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}}, 10));
    }
}
