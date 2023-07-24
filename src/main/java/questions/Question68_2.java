package questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import questions.utils.TreeNode;

public class Question68_2 {

    private Map<Integer, TreeNode> parent = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                parent.put(node.left.val, node);
                dfs(node.left);
            }
            if (node.right != null) {
                parent.put(node.right.val, node);
                dfs(node.right);
            }
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode l = lowestCommonAncestor2(root.left, p, q);
        TreeNode r = lowestCommonAncestor2(root.right, p, q);

        return l == null ? r : (r == null ? l : root);
    }
}
