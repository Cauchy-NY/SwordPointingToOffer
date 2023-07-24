package questions;

public class Question64 {

    public int sumNums(int n) {
        return n == 1 ? 1 : n + sumNums(n - 1);
    }

    public static void main(String[] args) {
        Question64 question64 = new Question64();
        System.out.println(question64.sumNums(3));
    }
}
