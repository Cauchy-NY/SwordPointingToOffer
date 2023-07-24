package questions;

import java.util.ArrayList;
import java.util.List;

public class Question57_2 {

    public int[][] findContinuousSequence(int target) {
        List<int[]> ret = new ArrayList<>();
        int i = 1, j = 2;
        while (i < j) {
            int sum = (j - i + 1) * (i + j) / 2;
            if (sum == target) {
                int[] vec = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    vec[k - i] = k;
                }
                ret.add(vec);
                i++;
            } else if (sum < target) {
                j++;
            } else {
                i++;
            }
        }
        return ret.toArray(new int[ret.size()][]);
    }
}
