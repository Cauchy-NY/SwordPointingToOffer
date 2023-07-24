package questions;

public class Question16 {

    public double myPow(double x, int n) {
        return n >= 0 ? quickPow(x, n) : 1.0 / quickPow(x, -n);
    }

    private double quickPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickPow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        Question16 question16 = new Question16();
        System.out.println(question16.myPow(2.1, 3));
    }
}
