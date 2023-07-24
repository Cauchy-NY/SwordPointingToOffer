package questions;

public class Question21 {

    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 == 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j--;
            } else {
                i++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Question21 question21 = new Question21();
        question21.exchange(new int[]{1, 2, 3, 4});
    }
}
