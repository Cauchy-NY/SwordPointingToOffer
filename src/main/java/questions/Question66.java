package questions;

public class Question66 {

    public int[] constructArr(int[] a) {
        if (a == null || a.length < 2) {
            return new int[]{};
        }
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = right[len - 1] = 1;
        for (int i = 1, j = len - 2; i < len && j >= 0; i++, j--) {
            left[i] = left[i - 1] * a[i - 1];
            right[j] = right[j + 1] * a[j + 1];
        }
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            ret[i] = left[i] * right[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        Question66 question66 = new Question66();
        int[] ret = question66.constructArr(new int[]{1, 2, 3, 4, 5});
        System.out.println(ret.length);
    }
}
