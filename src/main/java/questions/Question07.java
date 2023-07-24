package questions;

import questions.utils.TreeNode;

public class Question07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int pStart, int pEnd,
        int[] inorder, int iStart, int iEnd) {

        if (pStart >= pEnd || iStart >= iEnd) {
            return null;
        }

        int rootVal = preorder[pStart];

        int rootIdx = iStart, leftTreeSize = 0;
        for (; rootIdx < iEnd; rootIdx++, leftTreeSize++) {
            if (inorder[rootIdx] == rootVal) {
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, pStart + 1, pStart + 1 + leftTreeSize,
            inorder, iStart, rootIdx);
        root.right = buildTree(preorder, pStart + leftTreeSize + 1, pEnd,
            inorder, rootIdx + 1, iEnd);
        return root;
    }

    public static void main(String[] args) {
        Question07 question07 = new Question07();
        TreeNode root = question07.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
