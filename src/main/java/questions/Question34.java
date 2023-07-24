package questions;

import java.util.LinkedList;
import java.util.List;
import questions.utils.TreeNode;

public class Question34 {

    private List<Integer> path = new LinkedList<>();

    private List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ret;
    }

    private void dfs(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        target -= node.val;
        if (node.left == null && node.right == null && target == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(node.left, target);
        dfs(node.right, target);
        path.remove(path.size() - 1);
    }
}
