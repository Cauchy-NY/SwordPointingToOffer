package questions;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question48 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int maxLen = 0;
        while (j < s.length()) {
            while (j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }
            maxLen = Math.max(maxLen, j - i);
            if (j == s.length()) {
                break;
            }
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Question48 question48 = new Question48();
        System.out.println(question48.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(question48.lengthOfLongestSubstring("bbbbb"));
        System.out.println(question48.lengthOfLongestSubstring("pwwkew"));
    }
}
