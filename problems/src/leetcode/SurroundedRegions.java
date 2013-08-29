package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region .
 * 
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * @author chengyangwu
 *
 */
public class SurroundedRegions {
	public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if (board == null) return;
        if (board.length == 0) return;
        if (board[0].length == 0) return;
        
        // the first line and the last line is false
        for (int i = 0; i < board[0].length; i ++) {
            if (board[0][i] == 'O') bfs (0, i, board);
            if (board[board.length - 1][i] == 'O') bfs (board.length - 1, i, board);
        }
        
        // the first column and the last column is false
        for (int i = 0; i < board.length - 1; i ++) {
            if (board[i][0] == 'O') bfs (i, 0, board);
            if (board[i][board[0].length - 1] == 'O') bfs (i, board[0].length - 1, board);
        }
        
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '+') board[i][j] = 'O';
            }
        }
        
    }
    
    public void bfs (int i, int j, char[][] board) {
        Queue<Integer> q = new LinkedList<Integer> ();
        visit (i, j, board, q);
        while (!q.isEmpty()) {
            int cur = q.poll();
            int iP = cur/board[0].length;
            int jP = cur%board[0].length;
            visit (iP - 1, jP, board, q);
            visit (iP + 1, jP, board, q);
            visit (iP, jP + 1, board, q);
            visit (iP, jP - 1, board, q);
        }
    }
    
    public void visit (int i, int j, char[][] board, Queue<Integer> q) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        
        board[i][j] = '+';
        q.add(i * board[0].length + j);
    }
}
