package questions;

import java.util.Deque;
import java.util.LinkedList;

public class Question59_2 {

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }
}

class MaxQueue {

    private Deque<Integer> queue;
    private Deque<Integer> maxQueue;

    public MaxQueue() {
        this.queue = new LinkedList<>();
        this.maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.peek();
    }

    public void push_back(int value) {
        queue.offerLast(value);
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.pollLast();
        }
        maxQueue.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int ret = queue.pollFirst();
        if (maxQueue.peek() == ret) {
            maxQueue.pop();
        }
        return ret;
    }
}
