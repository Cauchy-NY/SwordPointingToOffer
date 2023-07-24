package questions;

public class Question62 {

    // n个人时，第一个出局的是m%n，第n-1个人时，出局的为x=lastRemaining(n-1, m)，则其在原本的序列中应该位于m%n+x
    // 一个人时，lastRemaining(1, m) = 0
    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = lastRemaining(n - 1, m);
        return (m + x) % n;
    }

    public int lastRemaining2(int n, int m) {
        int f = 0;
        for (int i = 2; i <= n; i++) {
            f = (m + f) % i;
        }
        return f;
    }

    public static void main(String[] args) {
        Question62 question62 = new Question62();
        System.out.println(question62.lastRemaining(5, 3));
        System.out.println(question62.lastRemaining(10, 17));
    }
}
