package solutions.leetcode.solution838;

import java.util.ArrayList;

public class Solution {
    public String pushDominoes(String dominoes) {
        StringBuffer result = new StringBuffer();

        int previousPosition = 0;
        int previousSide = 0;   // 0 = '.', 1 = 'R', -1 = 'L';

        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'R') {
                if (previousSide == 1)
                    result.append("R".repeat(i - previousPosition));
                else if (previousSide == -1) {
                    result.append('L');
                    result.append(".".repeat(i - (previousPosition + 1)));
                } else
                    result.append(".".repeat(i));

                previousPosition = i;
                previousSide = 1;
            }

            if (dominoes.charAt(i) == 'L') {
                if (previousSide == -1) {
                    result.append("L".repeat(i - previousPosition));
                } else if (previousSide == 1) {
                    result.append("R".repeat((previousPosition + i + 1) / 2 - previousPosition));

                    if ((previousPosition + i) % 2 == 0)
                        result.append('.');

                    result.append("L".repeat(i - ((previousPosition + i) / 2 + 1)));

                } else {
                    result.append("L".repeat(i));
                }
                previousPosition = i;
                previousSide = -1;
            }
        }

        if (previousSide == -1) {
            result.append('L');
            result.append(".".repeat(Math.max(0, dominoes.length() - (previousPosition + 1))));
        } else if (previousSide == 1)
            result.append("R".repeat(dominoes.length() - previousPosition));
        else
            return dominoes;

        return result.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pushDominoes(".L.R...LR..L.."));
        System.out.println(solution.pushDominoes("RR.L"));
        System.out.println(solution.pushDominoes("..."));
    }
}



//  R.
//  .R