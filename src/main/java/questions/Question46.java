package questions;

public class Question46 {

    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < str.length(); i++) {
            int sum = (str.charAt(i - 1) - '0') * 10 + (str.charAt(i) - '0');
            if (10 <= sum && sum <= 25) {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[str.length()];
    }

    public static void main(String[] args) {
        Question46 question46 = new Question46();
        System.out.println(question46.translateNum(0));
        System.out.println(question46.translateNum(1));
        System.out.println(question46.translateNum(506));
        System.out.println(question46.translateNum(18580));
        System.out.println(question46.translateNum(1225));
        System.out.println(question46.translateNum(12258));
    }
}
