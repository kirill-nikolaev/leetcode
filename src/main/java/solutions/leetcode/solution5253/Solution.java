package solutions.leetcode.solution5253;

public class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] result = new long[queries.length];
        if (intLength == 1) {
            for (int i = 0; i < queries.length; i++) {
                if (queries[i] > 9)
                    result[i] = -1;
                else
                    result[i] = queries[i];
            }
            return result;
        }

        if (intLength == 2) {
            for (int i = 0; i < queries.length; i++) {
                if (queries[i] > 9)
                    result[i] = -1;
                else
                    result[i] = queries[i] + queries[i] * 10L;
            }
            return result;
        }

        int maxNumber = (int) Math.pow(10, (intLength - 1) / 2 - 1);
        for (int i = 0; i < queries.length; i++) {
            queries[i]--;
        }

        for (int i = 0; i < queries.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((queries[i] / (10 * maxNumber) + 1));
            if (stringBuilder.length() > 1) {
                result[i] = -1;
                continue;
            }
            queries[i] = queries[i] % (10 * maxNumber);
            int temp = maxNumber;
            do {
                stringBuilder.append(queries[i] / temp);
                queries[i] = queries[i] % temp;
                temp = temp / 10;
            } while (temp > 0);
            String number = stringBuilder.toString();
            if (intLength % 2 == 1)
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            number = number + stringBuilder.reverse();
            result[i] = Long.parseLong(number);
        }
        return result;
    }
}
