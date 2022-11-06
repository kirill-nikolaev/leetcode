package solutions.leetcode.solution899;

import java.util.Arrays;

public class Solution {
    public String orderlyQueue(String s, int k) {

        int l = s.length();

        if (k > 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

        int min = 0;

        for (int i = 0; i < l; i++) {
            if (compareStrings(s, i, min)) {
                min = i;
            }
        }

        char[] chars = new char[l];

        for (int i = 0; i < l; i++) {
            chars[i] = s.charAt((i + min) % l);
        }

        return new String(chars);
    }

    private boolean compareStrings(String s, int current, int min) {
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char ch1 = s.charAt((current + i) % l);
            char ch2 = s.charAt((min + i) % l);
            if (ch1 != ch2)
                return ch1 < ch2;
        }

        return false;
    }
}
