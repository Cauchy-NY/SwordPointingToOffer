package questions;

import java.util.Objects;

public class Question15 {

    public int hammingWeight(long n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public int hammingWeight3(long n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                count++;
            }
            n /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        Question15 question15 = new Question15();
        System.out.println(question15.hammingWeight(11));
        System.out.println(question15.hammingWeight(128));
        System.out.println(question15.hammingWeight(4294967293L));

        String a = "aaa";
        String b = "aaa";
        System.out.println(getObj(a).hashCode());
        System.out.println(getObj(b).hashCode());
    }

    private static Object getObj(String val) {
        return val;
    }
}
