package questions;

public class Question19 {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] match = new boolean[m + 1][n + 1];
        match[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (isMatch(s, p, i, j - 1)) {
                        match[i][j] = match[i][j - 2] || match[i - 1][j];
                    } else {
                        match[i][j] = match[i][j - 2];
                    }
                } else {
                    if (isMatch(s, p, i, j)) {
                        match[i][j] = match[i - 1][j - 1];
                    } else {
                        match[i][j] = false;
                    }
                }
            }
        }
        return match[m][n];
    }

    private boolean isMatch(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        Question19 question19 = new Question19();
        System.out.println(question19.isMatch("aa", "a"));
        System.out.println(question19.isMatch("aa", "a*"));
        System.out.println(question19.isMatch("ab", ".*"));
        System.out.println(question19.isMatch("aab", "c*a*b"));
    }
}
