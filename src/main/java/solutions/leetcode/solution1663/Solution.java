package solutions.leetcode.solution1663;

import java.util.Arrays;

public class Solution {
    public String getSmallestString(int n, int k) {
        char[] resultArray = new char[n];
        Arrays.fill(resultArray, 'a');
        k = k - n;
        int index = n - 1;
        while (k > 0) {
            if (k > 25) {
                resultArray[index] = 'z';
                --index;
                k -= 25;
            } else {
                resultArray[index] = (char) (k + 'a');
                k = 0;
            }
        }

        return new String(resultArray);
    }
}
