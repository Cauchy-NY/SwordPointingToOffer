package questions.older;

import util.TreeNode;

import java.util.*;

public class Question06 {
    public static void main(String[] args) {
        int[] preOrders = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrders = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = createTree(preOrders, inOrders);

        binaryTreeMidOrder(root);
        binaryTreePreOrder(root);
        binaryTreePostOrder(root);
        binaryTreeLevelOrder(root);
    }

    private static TreeNode createTree(int[] preOrders, int[] inOrders) {
        if (preOrders.length == 0 || inOrders.length == 0)
            return null;

        TreeNode root = new TreeNode(preOrders[0]);
        int index = Arrays.binarySearch(inOrders, root.val);
        root.left = createTree(Arrays.copyOfRange(preOrders, 1, index + 1),
                Arrays.copyOfRange(inOrders, 0, index));
        root.right = createTree(Arrays.copyOfRange(preOrders, index + 1, preOrders.length),
                Arrays.copyOfRange(inOrders, index + 1, inOrders.length));

        return root;
    }

    /**
     * 二叉树先序遍历（递归）
     * @param root
     */
    public static void binaryTreePreOrder(TreeNode root){
        if (root == null)
            return;

        System.out.print(root.val + " ");
        binaryTreePreOrder(root.left);
        binaryTreePreOrder(root.right);
    }
    /**
     * 二叉树先序遍历（循环）
     * @param root
     */
    public static void binaryTreePreOrder_loop(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.print(cur.val + " ");
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }

    /**
     * 二叉树中序遍历（递归）
     * @param root
     */
    public static void binaryTreeMidOrder(TreeNode root){
        if (root == null)
            return;

        binaryTreeMidOrder(root.left);
        System.out.print(root.val + " ");
        binaryTreeMidOrder(root.right);
    }

    /**
     * 二叉树中序遍历（循环）
     * @param root
     */
    public static void binaryTreeMidOrder_loop(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }
    /**
     * 二叉树后序遍历（递归）
     * @param root
     */
    public static void binaryTreePostOrder(TreeNode root){
        if (root == null)
            return;

        binaryTreePostOrder(root.left);
        binaryTreePostOrder(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 二叉树后序遍历（非递归）
     * 先处理左右子树，再处理根
     * @param root
     */
    public static void binaryTreePostOrder_loop(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        //使用map来标记已经访问过的节点
        Map<TreeNode, Boolean> nodeMap = new HashMap<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            //获取左子树的左节点
            if (temp.left != null && !nodeMap.containsKey(temp.left)) {
                temp = temp.left;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
                continue;
            }
            //获取右节点
            if (temp.right != null && !nodeMap.containsKey(temp.right)) {
                stack.push(temp.right);
                continue;
            }
            TreeNode cur = stack.pop();
            System.out.print(cur.val + " ");
            nodeMap.put(cur, true);
        }
    }

    /**
     * 二叉树层次遍历
     * @param root
     */
    public static void binaryTreeLevelOrder(TreeNode root){
        //使用队列来实现遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            System.out.print(parent.val + " ");

            if (parent.left != null)
                queue.add(parent.left);

            if (parent.right != null)
                queue.add(parent.right);
        }
    }
}
