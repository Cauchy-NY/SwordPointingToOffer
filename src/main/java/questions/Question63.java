package questions;

public class Question63 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int preMin = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - preMin);
            preMin = Math.min(preMin, prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Question63 question63 = new Question63();
        System.out.println(question63.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(question63.maxProfit(new int[]{7, 6, 4, 3, 1}));
//        System.out.println(question63.maxProfit(new int[]{}));
    }
}
