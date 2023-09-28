package leetcode150daysDFS;

//Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
//
//A region is captured by flipping all 'O's into 'X's in that surrounded region.

public class SurroundedRegions {

	void dfs(char[][] board, int i, int j) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O')
			return;
		board[i][j] = '#';

		dfs(board, i - 1, j);
		dfs(board, i, j - 1);
		dfs(board, i + 1, j);
		dfs(board, i, j + 1);
	}

	public void solve(char[][] board) {

		int m = board.length;
		int n = board[0].length;

		for (int j = 0; j < n; j++) {

			if (board[0][j] == 'O') {
				dfs(board, 0, j);
			}

			if (board[m - 1][j] == 'O')
				dfs(board, m - 1, j);
		}

		for (int j = 0; j < m; j++) {

			if (board[j][0] == 'O') {
				dfs(board, j, 0);
			}

			if (board[j][n - 1] == 'O')
				dfs(board, j, n - 1);
		}

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				if (board[i][j] == 'O')
					board[i][j] = 'X';
				else if (board[i][j] == '#')
					board[i][j] = 'O';
			}
		}
	}

}
