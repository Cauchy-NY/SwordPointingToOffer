package questions;

import questions.utils.TreeNode;

public class Question54 {

    private int ret, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ret;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            this.ret = root.val;
        }
        dfs(root.left);
    }

//    private Map<TreeNode, Integer> map = new HashMap<>();
//
//    public int kthLargest(TreeNode root, int k) {
//        int index = countSub(root.right) + 1;
//        if (k == index) {
//            return root.val;
//        } else if (k > index) {
//            return kthLargest(root.left, k - index);
//        } else {
//            return kthLargest(root.right, k);
//        }
//    }
//
//    private int countSub(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        if (map.containsKey(root)) {
//            return map.get(root);
//        }
//        int cnt = countSub(root.right) + countSub(root.left) + 1;
//        map.put(root, cnt);
//        return cnt;
//    }

    public static void main(String[] args) {
        Question54 question54 = new Question54();
    }
}
