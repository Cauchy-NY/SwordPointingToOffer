package questions;

public class Question14_1 {

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Question14_1 question14_1 = new Question14_1();
        System.out.println(question14_1.cuttingRope(2));
        System.out.println(question14_1.cuttingRope(10));
    }
}
