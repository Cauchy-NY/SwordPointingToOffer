package questions;

import questions.utils.TreeNode;

public class Question55_2 {

    public boolean isBalanced(TreeNode root) {
        return getDepth(root) == -1;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        if (leftDepth < 0 || rightDepth < 0) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
