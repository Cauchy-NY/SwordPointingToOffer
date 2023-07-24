package questions;

import java.util.ArrayList;
import java.util.List;

public class Question50 {

    public char firstUniqChar(String s) {
        if (s == null || s.equals("")) {
            return ' ';
        }
        int[] cnt = new int[26];
        List<Character> seq = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (++cnt[s.charAt(i) - 'a'] == 1) {
                seq.add(s.charAt(i));
            }
        }
        for (char c : seq) {
            if (cnt[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Question50 question50 = new Question50();
        System.out.println(question50.firstUniqChar("abaccdeff"));
        System.out.println(question50.firstUniqChar(""));
    }
}
