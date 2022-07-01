package solutions.leetcode.solution5237;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> lists = new ArrayList<>();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            matrix[edges[i][0]][edges[i][1]] = 1;
        }
        for (int i = 0; i < edges.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < edges.length; j++) {
                if (matrix[j][i] == 1)
                    list.add(j);
            }
        }
        return lists;
    }
}
