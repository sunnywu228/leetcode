package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions_another {
	public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (board == null) return;
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;
        
        // the first line and the last line is false
        for (int i = 0; i < n; i ++) {
            if (board[0][i] == 'O') bfs (0, i, board);
            if (board[m - 1][i] == 'O') bfs (m - 1, i, board);
        }
        
        // the first column and the last column is false
        for (int i = 0; i < m - 1; i ++) {
            if (board[i][0] == 'O') bfs (i, 0, board);
            if (board[i][n - 1] == 'O') bfs (i, n - 1, board);
        }
        
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '+') board[i][j] = 'O';
            }
        }
        
    }
    
    public void bfs (int i, int j, char[][] board) {
        Queue<Integer> q = new LinkedList<Integer> ();
        visit (i, j, board, q);
        int n = board[0].length;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int iP = cur/n;
            int jP = cur%n;
            visit (iP - 1, jP, board, q);
            visit (iP + 1, jP, board, q);
            visit (iP, jP + 1, board, q);
            visit (iP, jP - 1, board, q);
        }
    }
    
    public void visit (int i, int j, char[][] board, Queue<Integer> q) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') {
            return;
        }
        
        board[i][j] = '+';
        q.add(i * n + j);
    }
}
