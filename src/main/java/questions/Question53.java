package questions;

public class Question53 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1, index = -1;
        while (left <= right) {
            index = (left + right) / 2;
            if (nums[index] == target) {
                break;
            } else if (nums[index] > target) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        if (nums[index] == target) {
            int cnt = 0, cur = index;
            while (cur < nums.length && nums[cur] == target) {
                cnt++;
                cur++;
            }
            cur = index - 1;
            while (cur >= 0 && nums[cur] == target) {
                cnt++;
                cur--;
            }
            return cnt;
        }
        return 0;
    }

    public static void main(String[] args) {
        Question53 question53 = new Question53();
        System.out.println(question53.search(new int[]{5,7,7,8,8,10}, 8));
        System.out.println(question53.search(new int[]{1}, 1));
    }
}
