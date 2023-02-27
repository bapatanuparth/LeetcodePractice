package leetcodeGraphs;

//We will use boundary DFS to solve this problem

// Let's analyze when an 'O' cannot be flipped,
// if it has atleast one 'O' in it's adjacent, AND ultimately this chain of adjacent 'O's is connected to some 'O' which lies on boundary of board

//consider these two cases for clarity :
/*
  O's won't be flipped          O's will be flipped
  [X O X X X]                   [X X X X X]     
  [X O O O X]                   [X O O O X]
  [X O X X X]                   [X O X X X] 
  [X X X X X]                   [X X X X X]

So we can conclude if a chain of adjacent O's is connected some O on boundary then they cannot be flipped

*/

//Steps to Solve :
//1. Move over the boundary of board, and find O's 
//2. Every time we find an O, perform DFS from it's position
//3. In DFS convert all 'O' to '#'      (why?? so that we can differentiate which 'O' can be flipped and which cannot be)   
//4. After all DFSs have been performed, board contains three elements,#,O and X
//5. 'O' are left over elements which are not connected to any boundary O, so flip them to 'X'
//6. '#' are elements which cannot be flipped to 'X', so flip them back to 'O'
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
