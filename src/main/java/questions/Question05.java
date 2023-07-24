package questions;

public class Question05 {

    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Question05 question05 = new Question05();
        System.out.println(question05.replaceSpace("I have a dream"));
    }
}
