package questions;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import questions.utils.TreeNode;

public class Question32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        Deque<Integer> row = new LinkedList<>();
        int curLevelSize = 1, nextLevelSize = 0;
        boolean isLeftToRight = true;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (isLeftToRight) {
                row.offerLast(cur.val);
            } else {
                row.offerFirst(cur.val);
            }
            if (cur.left != null) {
                queue.offer(cur.left);
                nextLevelSize++;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nextLevelSize++;
            }
            if (row.size() == curLevelSize) {
                ret.add(new LinkedList<>(row));
                row = new LinkedList<>();
                curLevelSize = nextLevelSize;
                nextLevelSize = 0;
                isLeftToRight = !isLeftToRight;
            }
        }
        return ret;
    }
}
