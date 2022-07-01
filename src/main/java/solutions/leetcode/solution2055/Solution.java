package solutions.leetcode.solution2055;

public class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] candleNumber1 = new int[s.length()];
        int[] candleNumber2 = new int[s.length()];
        int prevPlateIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (prevPlateIndex == -1) {
                if (s.charAt(i) == '|')
                    prevPlateIndex = i;
                continue;
            }

            if (s.charAt(i) == '*')
                candleNumber1[i] = candleNumber1[prevPlateIndex];
            else {
                candleNumber1[i] = candleNumber1[prevPlateIndex] + i - prevPlateIndex - 1;
                candleNumber2[i] = candleNumber1[i];

                for (int j = prevPlateIndex + 1; j <= i; j++) {
                    candleNumber2[j] = candleNumber2[i];
                }

                prevPlateIndex = i;
            }
        }
        if (prevPlateIndex != -1) {
            for (int i = prevPlateIndex; i < s.length(); i++) {
                candleNumber2[i] = candleNumber2[prevPlateIndex];
            }
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            result[i] = candleNumber1[queries[i][1]] - candleNumber2[queries[i][0]];
            if (result[i] < 0)
                result[i] = 0;
        }

        return result;
    }
}
