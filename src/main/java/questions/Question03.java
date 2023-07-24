package questions;

import java.util.Arrays;
import java.util.HashSet;

public class Question03 {

    // nums取值范围为[0, n-1]
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    private int findRepeatNumberWithSort(int[] nums) {
        Arrays.sort(nums);
        int prev = -1;
        for (int num : nums) {
            if (num == prev) {
                return num;
            }
            prev = num;
        }
        return -1;
    }

    private int findRepeatNumberWithSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Question03 question03 = new Question03();
//        System.out.println(question03.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(question03.findRepeatNumber(new int[]{3, 4, 2, 1, 1, 0}));
    }
}
