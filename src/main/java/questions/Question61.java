package questions;

import java.util.Arrays;

public class Question61 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int cur = 0, kingCnt = 0;
        while (nums[cur] == 0) {
            kingCnt++;
            cur++;
        }
        int curNum = nums[cur], straightNum = 0;
        while (cur < nums.length) {
            if (curNum != nums[cur]) {
                kingCnt--;
                if (kingCnt < 0) {
                    return false;
                }
            } else {
                cur++;
            }
            curNum++;
        }
        return true;
    }

    public static void main(String[] args) {
        Question61 question61 = new Question61();
        System.out.println(question61.isStraight(new int[]{0, 0, 2, 2, 5}));
        System.out.println(question61.isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println(question61.isStraight(new int[]{0, 0, 1, 2, 5}));
    }
}
