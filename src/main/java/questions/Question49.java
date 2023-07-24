package questions;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Question49 {

    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        queue.offer(1L);
        long ret = 0;
        while (n > 0) {
            ret = queue.poll();
            for (int factor : factors) {
                long mul = factor * ret;
                if (set.contains(mul)) {
                    continue;
                }
                queue.offer(mul);
                set.add(mul);
            }
            n--;
        }
        return (int) ret;
    }

    public int nthUglyNumber2(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Question49 question49 = new Question49();
        System.out.println(question49.nthUglyNumber(10));
    }
}
