package solutions.leetcode.solution113;

import solutions.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> currentPath;
    private List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        currentPath = new ArrayList<>();
        result = new ArrayList<>();

        if (root == null)
            return result;

        findPath(targetSum, 0, root);
        return result;
    }

    private void findPath(int targetSum, int currentSum, TreeNode treeNode) {
        currentSum = currentSum + treeNode.val;
        currentPath.add(treeNode.val);

        if (treeNode.left == null && treeNode.right == null) {
            if (currentSum == targetSum) {
                result.add(new ArrayList<>(currentPath));
            }
        }

        if (treeNode.left != null) {
            findPath(targetSum, currentSum, treeNode.left);
            currentPath.remove(currentPath.size() - 1);
        }

        if (treeNode.right != null) {
            findPath(targetSum, currentSum, treeNode.right);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
