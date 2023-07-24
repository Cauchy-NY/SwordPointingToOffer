package questions;

public class Question47 {

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int max = grid[i][j];
                if (i > 0) {
                    max = Math.max(max, grid[i][j] + dp[i - 1][j]);
                }
                if (j > 0) {
                    max = Math.max(max, grid[i][j] + dp[i][j - 1]);
                }
                dp[i][j] = max;
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Question47 question47 = new Question47();
        System.out.println(question47.maxValue(new int[][]{
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        }));
    }
}
