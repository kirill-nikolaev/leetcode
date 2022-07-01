package solutions.leetcode.solution5300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        List<List<Integer>> lists = new ArrayList<>();
        HashSet<Integer> noParens = new HashSet<>();
        boolean[] isFound = new boolean[n];
        List<HashSet<Integer>> ancestors = new ArrayList<>();
        List<HashSet<Integer>> notCheckedParens = new ArrayList<>();
        List<HashSet<Integer>> children = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            noParens.add(i);
        }

        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
            notCheckedParens.add(new HashSet<>());
            children.add(new HashSet<>());
        }

        for (int i = 0; i < edges.length; i++) {
            notCheckedParens.get(edges[i][1]).add(edges[i][0]);
            ancestors.get(edges[i][1]).add(edges[i][0]);
            children.get(edges[i][0]).add(edges[i][1]);
            noParens.remove(edges[i][1]);
        }

        for (Integer x : noParens) {
            setAllAncestors(x, children, notCheckedParens, ancestors);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(ancestors.get(i));
            list.sort((x, y) -> x - y);
            lists.add(list);
        }
        return lists;
    }
    private void setAllAncestors(int currentNode, List<HashSet<Integer>> children,
                                 List<HashSet<Integer>> notCheckedParens, List<HashSet<Integer>> ancestors) {
        for (Integer i: children.get(currentNode)) {
            notCheckedParens.get(i).remove(currentNode);

            for (Integer j: ancestors.get(currentNode)) {
                ancestors.get(i).add(j);
            }

            if (notCheckedParens.get(i).size() == 0) {
                setAllAncestors(i, children, notCheckedParens, ancestors);
            }
        }
    }
}
