package questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import questions.utils.TreeNode;

public class Question32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> cache = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            cache.add(cur.val);
        }
        int[] ret = new int[cache.size()];
        for (int i = 0; i < cache.size(); i++) {
            ret[i] = cache.get(i);
        }
        return ret;
    }
}
