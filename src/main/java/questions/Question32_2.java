package questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import questions.utils.TreeNode;

public class Question32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                row.add(cur.val);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            if (!row.isEmpty()) {
                ret.add(row);
            }
        }
        return ret;
    }
}
