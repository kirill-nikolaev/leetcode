package solutions.leetcode.solution1007;

public class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int first = tops[0];
        int second = bottoms[0];
        int firstTopAppearance = 0;
        int firstBottomAppearance = 0;
        int secondTopAppearance = 0;
        int secondBottomAppearance = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != first && bottoms[i] != first) {
                first = 0;
                break;
            }
            if (tops[i] == first)
                firstTopAppearance++;
            if (bottoms[i] == first)
                firstBottomAppearance++;
        }
        if (first == 0) {
            for (int i = 0; i < tops.length; i++) {
                if (tops[i] != second && bottoms[i] != second) {
                    second = 0;
                    break;
                }
                if (tops[i] == second)
                    secondTopAppearance++;
                if (bottoms[i] == second)
                    secondBottomAppearance++;
            }
        }

        if (first == 0 && second == 0) return -1;
        else if (first != 0) return Math.min(tops.length - firstTopAppearance, tops.length - firstBottomAppearance);
        else return Math.min(tops.length - secondTopAppearance, tops.length - secondBottomAppearance);
    }
}
