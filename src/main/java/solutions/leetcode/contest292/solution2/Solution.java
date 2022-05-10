package solutions.leetcode.contest292.solution2;

import solutions.leetcode.TreeNode;

public class Solution {
    private int count = 0;
    private int sum = 0;
    private int number = 0;
    public int averageOfSubtree(TreeNode root) {
        findCountOfCorrectRoots(root);
        return count;
    }

    private void findCountOfCorrectRoots(TreeNode root) {
        if (root == null)
            return;
        sum = 0;
        number = 0;
        getSumAndNumber(root);
        if  (root.val == sum / number)
            count++;
        findCountOfCorrectRoots(root.left);
        findCountOfCorrectRoots(root.right);
    }

    private void getSumAndNumber(TreeNode root) {
        if (root == null)
            return;
        sum += root.val;
        number++;
        getSumAndNumber(root.left);
        getSumAndNumber(root.right);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
