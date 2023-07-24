package questions.older;

import util.Node;

import java.util.Stack;

public class Question05 {
    /**
     * 从尾到头打印列表
     */
    public static void main(String[] args) {
        new Question05().reversePrint(Node.getALinkedList());
    }

    private void reversePrint(Node head) {
        if (head == null)
            return;

        Stack<Integer> stack = new Stack<Integer>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur.var);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }
}
