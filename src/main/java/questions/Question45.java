package questions;

import java.util.Arrays;

public class Question45 {

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> (a + b).compareTo(b + a));

        StringBuilder builder = new StringBuilder();
        for (String numStr : strs) {
            builder.append(numStr);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Question45 question45 = new Question45();
        System.out.println(question45.minNumber(new int[]{121, 12}));
        System.out.println(question45.minNumber(new int[]{3, 30}));
        System.out.println(question45.minNumber(new int[]{128, 12}));
        System.out.println(question45.minNumber(new int[]{10, 2}));
        System.out.println(question45.minNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
