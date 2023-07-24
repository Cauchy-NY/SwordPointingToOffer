package questions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Question59_1 {

    // TLE
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        int[] ret = new int[n];
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < k - 1; i++) {
            queue.offer(nums[i]);
        }
        for (int i = k - 1; i < nums.length; i++) {
            queue.offer(nums[i]);
            ret[i - k + 1] = queue.peek();
            queue.remove(nums[i - k + 1]);
        }
        return ret;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]
            if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                deque.removeFirst();
            }
            // 保持 deque 递减
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if (i >= 0) {
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }
}
