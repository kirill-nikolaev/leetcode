package solutions.leetcode.solution32;

import java.util.ArrayList;

public class Solution {
    public int longestValidParentheses(String s) {
        ArrayList<Positions> positions = new ArrayList<>();

        int maxPosition = s.length() - 1;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                positions.add(new Positions(i, i + 1));
            }
        }
        boolean b = true;
        while (b) {
            b = false;

            for (int i = 0; i < positions.size(); i++) {
                if (positions.get(i).first > 0 && s.charAt(positions.get(i).first - 1) == '(')
                    if (positions.get(i).last < maxPosition && s.charAt(positions.get(i).last + 1) == ')') {
                        positions.get(i).first--;
                        positions.get(i).last++;
                        b = true;
                    }
            }

            for (int i = 0; i < positions.size() - 1; i++) {
                if (positions.get(i).last + 1 == positions.get(i + 1).first) {
                    positions.get(i).last = positions.get(i + 1).last;
                    positions.remove(i + 1);
                    i--;
                    b = true;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < positions.size(); i++) {
            max = Math.max(max, positions.get(i).last - positions.get(i).first + 1);
        }

        return max;
    }

    private class Positions {
        int first;
        int last;

        public Positions(int first, int last) {
            this.first = first;
            this.last = last;
        }
    }
}
