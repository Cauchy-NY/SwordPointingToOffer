package questions;

import java.util.HashSet;
import java.util.Set;

public class Question38 {

    Set<String> ret = new HashSet<>();
    boolean[] visit;

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        visit = new boolean[chars.length];
        backtrack(chars, 0, new StringBuilder());
        return ret.toArray(new String[0]);
    }

    private void backtrack(char[] chars, int i, StringBuilder builder) {
        if (i == chars.length) {
            ret.add(builder.toString());
            return;
        }
        for (int j = 0; j < chars.length; j++) {
            if (visit[j]) {
                continue;
            }
            visit[j] = true;
            builder.append(chars[j]);
            backtrack(chars, i + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            visit[j] = false;
        }
    }
}
