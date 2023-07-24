package questions;

public class Question44 {

    public int findNthDigit(int n) {
        // 10 100-10 1000-100 10000-1000 100000-10000
        // 10 90 900 9000 90000
        // 1 2 3 4 5
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        return (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
    }

    public static void main(String[] args) {
        Question44 question44 = new Question44();
        System.out.println(question44.findNthDigit(3));
        System.out.println(question44.findNthDigit(11));
        System.out.println(question44.findNthDigit(13));
        System.out.println(question44.findNthDigit(19));
        System.out.println(question44.findNthDigit(30));
        System.out.println(question44.findNthDigit(123131313));
    }
}
