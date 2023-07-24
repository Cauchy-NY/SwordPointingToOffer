package questions;

import java.util.PriorityQueue;
import java.util.Queue;

public class Question41 {
    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
    }
}


class MedianFinder {

    private Queue<Integer> queueMin = new PriorityQueue<>((a, b) -> (b - a));
    private Queue<Integer> queueMax = new PriorityQueue<>((a, b) -> (a - b));

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (queueMin.isEmpty() || num <= queueMin.peek()) {
            queueMin.offer(num);
            while (queueMin.size() > queueMax.size() + 1) {
                queueMax.offer(queueMin.poll());
            }
        } else {
            queueMax.offer(num);
            while (queueMin.size() < queueMax.size()) {
                queueMin.offer(queueMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queueMin.size() != queueMax.size()) {
            return queueMin.peek();
        } else {
            return (queueMin.peek() + queueMax.peek()) / 2.0;
        }
    }
}