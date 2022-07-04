package solutions.leetcode.solution135;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    public int candy(int[] ratings) {
        int result = ratings.length;
        int[] change = new int[ratings.length];

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                change[i] = 1;
            else if (ratings[i] < ratings[i - 1])
                change[i] = -1;
        }

        int upLength = 0;
        int downLength = 0;
        int currentChange = 0;

        for (int i = 1; i < change.length; i++) {
            if (change[i] == 0) {
                result += Math.max(upLength, downLength);
                upLength = 0;
                downLength = 0;
                currentChange = 0;
            }
            else if (change[i] == 1) {
                if (currentChange == 1) {
                    result += upLength;
                    upLength++;
                } else {
                    result += Math.max(upLength, downLength);
                    upLength = 1;
                    downLength = 0;
                    currentChange = 1;
                }
            } else {
                if (currentChange == 1) {
                    downLength = 1;
                    currentChange = -1;
                }
                else if (currentChange == -1) {
                    result += downLength;
                    downLength++;
                } else {
                    result += Math.max(upLength, downLength);
                    upLength = 0;
                    downLength = 1;
                    currentChange = -1;
                }
            }
        }
        result += Math.max(upLength, downLength);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.candy(new int[]{1,0,2}));
        System.out.println(solution.candy(new int[]{1,2,2}));
        System.out.println(solution.candy(new int[]{1,2,3,4}));
        System.out.println(solution.candy(new int[]{4,3,2,1}));
    }
}
