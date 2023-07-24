package questions;

import java.util.PriorityQueue;
import java.util.Queue;

public class Question40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        for (int num :  arr) {
            queue.offer(num);
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = queue.poll();
        }
        return ret;
    }
}
