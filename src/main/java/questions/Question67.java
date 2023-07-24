package questions;

public class Question67 {

    public int strToInt(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        boolean isMinus = false;
        if (i < str.length() && str.charAt(i) == '-') {
            isMinus = true;
            i++;
        } else if (i < str.length() && str.charAt(i) == '+') {
            i++;
        }

        int ret = 0, bndry = Integer.MAX_VALUE / 10;
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            int digitNum = c - '0';
            if (digitNum < 0 || digitNum > 9) {
                break;
            }
            if (ret > bndry || ret == bndry && digitNum > 7) {
                return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ret = ret * 10 + digitNum;
        }
        return isMinus ? -ret : ret;
    }

    public static void main(String[] args) {
        Question67 question67 = new Question67();
        System.out.println(question67.strToInt(" "));
        System.out.println(question67.strToInt("-91283472332"));
        System.out.println(question67.strToInt("words and 987"));
        System.out.println(question67.strToInt("4193 with words"));
        System.out.println(question67.strToInt("   -42"));
        System.out.println(question67.strToInt("42"));
    }
}
