package questions;

import questions.utils.TreeNode;

public class Question55_1 {

    private int depth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return depth;
        }
        dfs(root, 0);
        return depth;
    }

    private void dfs(TreeNode node, int curDepth) {
        if (node == null) {
            depth = Math.max(depth, curDepth);
            return;
        }

        dfs(node.left, curDepth + 1);
        dfs(node.right, curDepth + 1);
    }
}
