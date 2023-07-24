package questions;

public class Question10_2 {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int a = 1, b = 1, ret = 0;
        for (int i = 1; i < n; i++) {
            ret = (a + b) % 1000000007;
            a = b;
            b = ret;
        }
        return ret;
    }
}
