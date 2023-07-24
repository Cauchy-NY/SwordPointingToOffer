package questions;

public class Question04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = matrix.length - 1, j = 0; i >= 0 && j < matrix[0].length; ) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Question04 question04 = new Question04();
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        System.out.println(question04.findNumberIn2DArray(matrix, 5));
        System.out.println(question04.findNumberIn2DArray(matrix, 31));
    }
}
