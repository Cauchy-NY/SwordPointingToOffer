package questions;

public class Question17 {
    public int[] printNumbers(int n) {
        int len = (int) Math.pow(10, n) - 1;
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        Question17 question17 = new Question17();
        System.out.println(question17.printNumbers(3).length);
    }
}
