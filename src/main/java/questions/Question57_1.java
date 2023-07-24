package questions;

public class Question57_1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] + nums[j] == target) {
                return new int[]{nums[i], nums[j]};
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{};
    }
}
