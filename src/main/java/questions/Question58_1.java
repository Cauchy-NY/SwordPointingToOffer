package questions;

import java.util.ArrayList;
import java.util.List;

public class Question58_1 {

    public String reverseWords(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        int l = 0, r = s.length() - 1;
        while (l < s.length() && s.charAt(l) == ' ') {
            l++;
        }
        while (r >= 0 && s.charAt(r) == ' ') {
            r--;
        }
        if (l > r) {
            return "";
        }
        List<String> words = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            while (i <= r && s.charAt(i) == ' ') {
                i++;
            }
            StringBuilder builder = new StringBuilder();
            while (i <= r && s.charAt(i) != ' ') {
                builder.append(s.charAt(i));
                i++;
            }
            words.add(builder.toString());
        }

        StringBuilder builder = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            builder.append(words.get(i));
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public static void main(String[] args) {
        Question58_1 question58_1 = new Question58_1();
        System.out.println(question58_1.reverseWords(""));
        System.out.println(question58_1.reverseWords(" "));
        System.out.println(question58_1.reverseWords("the sky is blue"));
        System.out.println(question58_1.reverseWords("  hello world!  "));
        System.out.println(question58_1.reverseWords("a good   example"));
    }
}
