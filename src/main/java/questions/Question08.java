package questions;

public class Question08 {

    public TreeNode getNextNode(TreeNode node) {
        if (node.right != null) {
            TreeNode cur = node.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        } else {
            TreeNode parent = node.next;
            while (parent != null) {
                if (parent.left == node) {
                    return parent;
                }
                parent = parent.next;
            }
        }
        return null;
    }

}

class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode next;

    int val;
}
