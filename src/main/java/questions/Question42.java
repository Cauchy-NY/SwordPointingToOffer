package questions;

public class Question42 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    // dp
    public int maxSubArray2(int[] nums) {
        int pre = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static void main(String[] args) {
        Question42 question42 = new Question42();
        System.out.println(question42.maxSubArray2(new int[]{1}));
        System.out.println(question42.maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(question42.maxSubArray2(new int[]{-2, 1, -3, -1, 2, 1, -5, 4}));
    }
}
