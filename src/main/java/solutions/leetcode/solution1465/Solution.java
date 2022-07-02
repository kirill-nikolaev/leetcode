package solutions.leetcode.solution1465;

import java.util.Arrays;

public class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxHorizontalCut = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        long maxVerticalCut = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);

        for (int i = 0; i < horizontalCuts.length - 1; i++)
            maxHorizontalCut = Math.max(maxHorizontalCut, horizontalCuts[i + 1] - horizontalCuts[i]);

        for (int i = 0; i < verticalCuts.length - 1; i++)
            maxVerticalCut = Math.max(maxVerticalCut, verticalCuts[i + 1] - verticalCuts[i]);

        return (int) ((maxHorizontalCut * maxVerticalCut) % 1_000_000_007);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(5, 4, new int[]{1,2,4}, new int[]{1,3}));
        System.out.println(solution.maxArea(5, 4, new int[]{3,1}, new int[]{1}));
    }
}
