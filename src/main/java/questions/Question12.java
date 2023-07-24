package questions;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question12 {

    Map<Integer, Set<Integer>> map = new HashMap<>();

    public boolean exist(char[][] board, String word) {
        if (word == null || word.equals("") || board == null) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int row, int col, int wordIdx) {
        if (wordIdx == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length) {
            return false;
        }
        if (col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] != word.charAt(wordIdx)) {
            return false;
        }
        if (map.containsKey(row)) {
            Set<Integer> set = map.get(row);
            if (set.contains(col)) {
                return false;
            } else {
                set.add(col);
            }
        } else {
            map.put(row, new HashSet<>(Collections.singletonList(col)));
        }

        boolean exist = exist(board, word, row + 1, col, wordIdx + 1) ||
            exist(board, word, row, col + 1, wordIdx + 1) ||
            exist(board, word, row - 1, col, wordIdx + 1) ||
            exist(board, word, row, col - 1, wordIdx + 1);
        map.get(row).remove(col);
        return exist;
    }

    public static void main(String[] args) {
        Question12 question12 = new Question12();
        System.out.println(question12.exist(new char[][]{
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'},
        }, "ABCCED"));

        System.out.println(question12.exist(new char[][]{
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'},
        }, "CCS"));
    }
}
