package questions;

import java.util.Stack;

public class Question09 {
    public static void main(String[] args) {
        CQueue queue = new CQueue();
        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}

class CQueue {

    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public CQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack2.push(value);
    }

    public int deleteHead() {
        if (!stack1.isEmpty()) {
            return stack1.pop();
        }
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return stack1.isEmpty() ? -1 : stack1.pop();
    }
}
