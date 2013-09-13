package problems.src.leetcode;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * User: chengyangwu
 * Date: 9/12/13
 * Time: 2:14 PM
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blks = new boolean[9][9];

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                rows[i][j] = false;
                cols[i][j] = false;
                blks[i][j] = false;
            }
        }

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.') continue;
                int val = board[i][j] - '1';
                if (rows[i][val] || cols[j][val] || blks[(i/3) * 3 + j / 3][val]) return false;
                rows[i][val] = true;
                cols[j][val] = true;
                blks[(i/3) * 3 + j / 3][val] = true;
            }
        }
        return true;
    }

    public boolean isValidSudoku_method2(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] blks = new int[9];

        for (int i = 0; i < 9; i ++) {
            rows[i] = 0;
            cols[i] = 0;
            blks[i] = 0;
        }

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.') continue;
                int val = board[i][j] - '0';
                if ((rows[i] & 1 << val) != 0) return false;
                if ((cols[j] & 1 << val) != 0) return false;
                if ((blks[(i/3) * 3 + j / 3] & 1 << val) != 0) return false;
                rows[i] |= 1 << val;
                cols[j] |= 1 << val;
                blks[(i/3) * 3 + j / 3] |= 1 << val;
            }
        }
        return true;
    }
}
