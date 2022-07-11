package solutions.leetcode.solution199;

import solutions.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        List<TreeNode> currentDeep = new ArrayList<>();
        currentDeep.add(root);

        List<TreeNode> nextDeep = new ArrayList<>();

        while (currentDeep.size() != 0) {
            result.add(currentDeep.get(0).val);
            for (TreeNode x: currentDeep) {
                if (x.right != null)
                    nextDeep.add(x.right);
                if (x.left != null)
                    nextDeep.add(x.left);
                currentDeep = nextDeep;
            }
            nextDeep = new ArrayList<>();
        }

        return result;
    }
}
