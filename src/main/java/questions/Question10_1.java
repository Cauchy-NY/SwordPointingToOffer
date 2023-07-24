package questions;

public class Question10_1 {

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0, b = 1, ret = 0;
        for (int i = 1; i < n; i++) {
            ret = (a + b) % 1000000007;
            a = b;
            b = ret;
        }
        return ret;
    }
}
