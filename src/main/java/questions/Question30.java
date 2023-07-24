package questions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Question30 {

}

class MinStack {

    private Deque<Integer> stack = new LinkedList<>();
    private Deque<Integer> minStack = new LinkedList<>();

    /** initialize your data structure here. */
    public MinStack() {
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(x, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
