package questions;

public class Question39 {

    public int majorityElement(int[] nums) {
        int cnt = 0, cur = nums[0];
        for (int num : nums) {
            if (cnt == 0) {
                cur = num;
            }
            cnt += (num == cur) ? 1 : -1;
        }
        return cur;
    }

    public static void main(String[] args) {
        Question39 question39 = new Question39();
        System.out.println(question39.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
        System.out.println(question39.majorityElement(new int[]{2, 2, 2, 1, 3}));
    }
}
