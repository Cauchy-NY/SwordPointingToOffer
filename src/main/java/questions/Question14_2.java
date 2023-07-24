package questions;

import java.math.BigInteger;
import java.util.Arrays;

public class Question14_2 {

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) {
                rem = (rem * x) % p;
            }
            x = (x * x) % p;
        }
        if (b == 0) {
            return (int) (rem * 3 % p);
        }
        if (b == 1) {
            return (int) (rem * 4 % p);
        }
        return (int) (rem * 6 % p);
    }

    public int cuttingRope2(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.valueOf(1));
        for (int i = 2; i <= n; i++) {
            BigInteger curMax = BigInteger.valueOf(1);
            for (int j = 1; j < i; j++) {
                curMax = curMax.max(BigInteger.valueOf((long) j * (i - j))
                    .max(dp[i - j].multiply(BigInteger.valueOf(j))));
            }
            dp[i] = curMax;
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public static void main(String[] args) {
        Question14_2 question14_2 = new Question14_2();
        System.out.println(question14_2.cuttingRope(2));
        System.out.println(question14_2.cuttingRope(10));
    }
}
