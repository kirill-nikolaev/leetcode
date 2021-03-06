package solutions.leetcode.solution2267;

import java.util.HashSet;


public class Solution {
    private int m;
    private int n;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if (n + m % 2 == 0 || grid[0][0] == ')')
            return false;

        HashSet<Integer>[][] sets = new HashSet[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sets[i][j] = new HashSet<Integer>();
            }
        }
        sets[0][0].add(1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                fillSets(grid, sets, i, j);
            }
        }
        return sets[m - 1][n - 1].contains(0);
    }


    private void fillSets(char[][] grid, HashSet<Integer>[][] sets, int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return;
        }

        if (x != m - 1) {
            int delta = 1;
            if (grid[x + 1][y] == ')')
                delta = -1;
            for (Integer elem: sets[x][y]) {
                if (elem + delta >= 0)
                    sets[x + 1][y].add(elem + delta);
            }
        }

        if (y != n - 1) {
            int delta = 1;
            if (grid[x][y + 1] == ')')
                delta = -1;
            for (Integer elem: sets[x][y]) {
                if (elem + delta >= 0)
                    sets[x][y + 1].add(elem + delta);
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasValidPath(new char[][]{{'(','(','('},{')','(',')'},{'(','(',')'},{'(','(',')'}}));
        System.out.println(solution.hasValidPath(new char[][]{{'(','(',')','(',')','(','(',')','(','(',')',')',')',')',')','(',')','(','(',')','(','(',')',')',')',')',')','(','(','(','('},{')','(','(','(',')','(',')','(','(',')',')',')',')','(',')',')','(','(',')',')','(',')','(',')','(','(',')','(',')','(','('},{')',')','(','(',')','(','(',')',')',')',')','(','(',')',')','(',')','(',')',')','(','(','(',')',')',')','(',')',')','(',')'},{'(','(',')','(',')','(','(',')','(','(','(',')',')','(',')','(',')',')',')',')',')',')','(','(',')','(',')','(',')','(','('},{')',')','(',')',')','(','(','(',')',')','(',')','(',')',')',')','(','(','(',')',')','(',')','(',')',')','(','(','(','(',')'},{')',')','(','(',')','(',')','(',')','(',')','(',')',')','(',')','(',')',')','(',')','(','(','(',')','(',')',')',')','(','('},{')','(','(','(','(','(','(',')',')','(','(',')','(',')',')','(',')',')',')','(','(','(',')','(','(',')',')','(',')','(',')'},{')',')','(','(','(','(','(','(','(',')',')','(','(','(','(','(','(','(','(','(','(','(','(',')',')','(','(',')',')','(',')'},{'(',')',')',')','(','(',')',')',')',')','(',')',')','(',')',')','(','(','(','(','(','(','(',')',')','(','(',')',')','(','('},{'(','(',')','(',')',')',')',')','(','(','(',')',')',')','(',')','(','(',')','(','(','(',')','(','(','(','(','(',')',')',')'},{'(',')','(','(','(','(',')','(','(',')',')','(','(',')','(','(','(',')','(','(','(',')',')','(',')',')','(',')','(','(',')'},{')',')','(','(','(','(',')','(','(',')',')','(',')',')','(',')','(','(','(','(','(','(','(',')','(','(',')',')','(','(','('},{'(',')',')',')','(',')','(','(','(',')',')',')','(',')','(',')',')','(','(','(','(',')','(',')',')',')',')',')',')','(','('},{'(','(','(','(','(','(',')',')','(',')','(','(','(',')',')','(',')','(',')','(',')','(','(','(',')',')',')','(',')','(','('},{'(',')',')',')',')','(','(',')',')',')',')',')',')','(','(',')','(',')',')','(',')','(',')',')',')','(','(',')','(','(','('},{'(',')',')','(','(',')',')','(',')',')','(','(','(',')',')',')',')','(','(','(',')',')','(',')','(','(','(','(',')',')',')'},{')','(','(',')','(','(',')',')',')','(','(','(','(',')','(',')',')',')','(',')','(',')','(','(',')','(','(','(','(','(','('},{'(',')','(',')','(','(',')',')',')',')',')','(','(',')',')','(',')','(',')',')',')',')','(','(','(',')','(',')','(',')',')'},{'(',')','(',')',')',')','(','(','(',')','(',')','(','(',')',')','(',')','(',')','(',')','(','(','(','(','(',')','(',')','('},{')',')',')',')',')','(',')',')','(','(',')','(',')',')','(',')',')','(','(','(','(',')','(','(','(','(',')',')',')',')','('},{')','(','(','(','(','(',')','(',')',')',')',')','(','(','(',')',')','(',')',')','(','(','(','(','(','(',')',')','(','(','('},{'(','(','(',')',')','(',')','(',')',')',')',')','(',')',')',')',')','(',')','(','(','(','(',')','(','(','(','(','(','(',')'}}));
    }
}
