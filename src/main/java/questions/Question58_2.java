package questions;

public class Question58_2 {
    public String reverseLeftWords(String s, int n) {
        String s1 = new StringBuilder(s.substring(0, n)).reverse().toString();
        String s2 = new StringBuilder(s.substring(n)).reverse().toString();
        return new StringBuilder(s1).append(s2).reverse().toString();
    }

    public static void main(String[] args) {
        Question58_2 question58_2 = new Question58_2();
        System.out.println(question58_2.reverseLeftWords("abcdefg", 2));
    }
}
