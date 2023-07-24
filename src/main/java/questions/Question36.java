package questions;

public class Question36 {

    Node newHead = new Node(-1);
    Node prev = newHead;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        visit(root);
        Node head = newHead.right;
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void visit(Node node) {
        if (node == null) {
            return;
        }
        visit(node.left);
        node.left = prev;
        prev.right = node;
        prev = node;
        visit(node.right);
    }

    class Node {

        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
