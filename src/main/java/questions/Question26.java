package questions;

import questions.utils.TreeNode;

public class Question26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (isEqual(A, B)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isEqual(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A != null && B != null && A.val == B.val) {
            return isEqual(A.left, B.left) && isEqual(A.right, B.right);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
