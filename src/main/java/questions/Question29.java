package questions;

public class Question29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] ret = new int[m * n];
        int curRow = 0, curCol = 0, directionIdx = 0;
        for (int i = 0; i < m * n; i++) {
            ret[i] = matrix[curRow][curCol];
            visited[curRow][curCol] = true;
            int nextRow = curRow + direction[directionIdx][0];
            int nextCol = curCol + direction[directionIdx][1];
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                directionIdx = (directionIdx + 1) % direction.length;
            }
            curRow += direction[directionIdx][0];
            curCol += direction[directionIdx][1];
        }
        return ret;
    }
}
