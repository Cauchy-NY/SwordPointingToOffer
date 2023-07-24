package questions;

public class Question33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return false;
        }
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int left, int right) {
        if (left == right) {
            return true;
        }
        int root = postorder[right];
        int i = left;
        for (; i < right; i++) {
            if (postorder[i] > root) {
                break;
            }
        }
        int j = i;
        for (; j < right; j++) {
            if (postorder[j] < root) {
                return false;
            }
        }
        boolean leftIsPostorder = true;
        if (i > left) {
            leftIsPostorder = verifyPostorder(postorder, left, i - 1);
        }
        boolean rightIsPostorder = true;
        if (j > i) {
            rightIsPostorder = verifyPostorder(postorder, i, right - 1);
        }
        return leftIsPostorder && rightIsPostorder;
    }

    public static void main(String[] args) {
        Question33 question33 = new Question33();
        System.out.println(question33.verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        System.out.println(question33.verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }
}
