package leetcodeGraphs;

public class Minesweeper {

	public char[][] updateBoard(char[][] board, int[] click) {
		int m = board.length;
		int n = board[0].length;

		int x = click[0];
		int y = click[1];

		if (board[x][y] == 'M') {
			board[x][y] = 'X';
			return board;
		}

		boolean[][] visited = new boolean[m][n];
		reveal(x, y, m, n, board, visited);

		return board;
	}

	int getcount(int x, int y, int m, int n, char[][] board) {

		int[][] directions = new int[][] { { -1, -1 }, { 0, -1 }, { 1, -1 }, { -1, 0 }, { 1, 0 }, { -1, 1 }, { 0, 1 },
				{ 1, 1 } };
		int count = 0;
		for (int i = 0; i < 8; i++) {

			x = x + directions[i][0];
			y = y + directions[i][1];

			if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'M')
				count++;
		}

		return count;
	}

	void reveal(int x, int y, int m, int n, char[][] board, boolean[][] visited) {

		if (!(x >= 0 && x < m && y >= 0 && y < n && !visited[x][y])) {
			return;
		}

		int count = getcount(x, y, m, n, board);
		if (count > 0) {
			board[x][y] = (char) (count + '0');
			return;
		}

		board[x][y] = 'B';
		visited[x][y] = true;

		reveal(x - 1, y, m, n, board, visited);
		reveal(x, y - 1, m, n, board, visited);
		reveal(x + 1, y, m, n, board, visited);
		reveal(x, y + 1, m, n, board, visited);
		reveal(x - 1, y - 1, m, n, board, visited);
		reveal(x + 1, y + 1, m, n, board, visited);
		reveal(x - 1, y + 1, m, n, board, visited);
		reveal(x + 1, y - 1, m, n, board, visited);

	}
}
