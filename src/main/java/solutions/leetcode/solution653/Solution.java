package solutions.leetcode.solution653;

import solutions.leetcode.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        createSetFromTree(root, hashSet);
        for (Integer value: hashSet) {
            if (hashSet.contains(k - value) && (k - value != value))
                return true;
        }
        return false;
    }

    private void createSetFromTree(TreeNode treeNode, Set<Integer> set) {
        if (treeNode == null)
            return;
        set.add(treeNode.val);
        createSetFromTree(treeNode.left, set);
        createSetFromTree(treeNode.right, set);
    }
}
