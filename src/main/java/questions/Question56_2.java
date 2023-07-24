package questions;

public class Question56_2 {
    public int singleNumber(int[] nums) {
        int[] a = new int[32];

        for (int i : nums) {
            for (int j = 0; j < 32; j ++) {
                if ((i >> j & 1) == 1) {
                    a[j] = (a[j] + 1) % 3;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i ++) {
            if (a[i] == 1) {
                res = res | (1 << i);
            }
        }

        return res;
    }

    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
