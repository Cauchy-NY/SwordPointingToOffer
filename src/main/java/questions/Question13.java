package questions;

public class Question13 {

    private int totalCnt = 0;

    public int movingCount(int m, int n, int k) {
        totalCnt = 0;
        boolean[][] visited = new boolean[m][n];
        dfs(m, n, k, 0, 0, visited);
        return totalCnt;
    }

    public void dfs(int m, int n, int k, int i, int j, boolean[][] visited) {
        if (i >= m || j >= n || i < 0 || j < 0 || getNum(i) + getNum(j) > k || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        totalCnt++;

        dfs(m, n, k, i + 1, j, visited);
        dfs(m, n, k, i - 1, j, visited);
        dfs(m, n, k, i, j + 1, visited);
        dfs(m, n, k, i, j - 1, visited);
    }

    private int getNum(int pos) {
        int cnt = 0;
        while (pos != 0) {
            cnt += pos % 10;
            pos /= 10;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Question13 question13 = new Question13();
        System.out.println(question13.movingCount(2, 3, 1));
        System.out.println(question13.movingCount(3, 1, 0));
    }
}
