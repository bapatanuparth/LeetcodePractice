package leetcode150daysDFS;

//You are given an m x n char matrix board representing the game board where:
//
//'M' represents an unrevealed mine,
//'E' represents an unrevealed empty square,
//'B' represents a revealed blank square that has no adjacent mines (i.e., above, below, left, right, and all 4 diagonals),
//digit ('1' to '8') represents how many mines are adjacent to this revealed square, and
//'X' represents a revealed mine.
//You are also given an integer array click where click = [clickr, clickc] represents the next click position among all the unrevealed squares ('M' or 'E').
//
//Return the board after revealing this position according to the following rules:
//
//If a mine 'M' is revealed, then the game is over. You should change it to 'X'.
//If an empty square 'E' with no adjacent mines is revealed, then change it to a revealed blank 'B' and all of its adjacent unrevealed squares should be revealed recursively.
//If an empty square 'E' with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
//Return the board when no more squares will be revealed.

public class Minesweeper {

	int[][] DIR = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

	public char[][] updateBoard(char[][] board, int[] click) {
		int m = board.length;
		int n = board[0].length;

		int x = click[0];
		int y = click[1];

		if (board[x][y] == 'M') {
			board[x][y] = 'X';
			return board;
		}

		dfs(x, y, board, new boolean[m][n]);
		return board;
	}

	int getCount(char[][] board, int[] click) {
		int x = click[0];
		int y = click[1];

		int count = 0;

		for (int[] dir : DIR) {
			int nx = dir[0] + x;
			int ny = dir[1] + y;
			if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length)
				continue;
			if (board[nx][ny] == 'M')
				count++;
		}

		return count;
	}

	void dfs(int i, int j, char[][] board, boolean[][] visited) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j])
			return;

		int count = getCount(board, new int[] { i, j });
		if (count > 0) {
			board[i][j] = (char) (count + '0');
			return;
		}
		board[i][j] = 'B';
		visited[i][j] = true;

		for (int[] dir : DIR) {
			int nx = dir[0] + i;
			int ny = dir[1] + j;
			if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length)
				continue;
			dfs(nx, ny, board, visited);
		}
	}

}
