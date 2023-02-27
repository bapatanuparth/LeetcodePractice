package leetcodeMatrix;

//According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
//
//The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
//
//Any live cell with fewer than two live neighbors dies as if caused by under-population.
//Any live cell with two or three live neighbors lives on to the next generation.
//Any live cell with more than three live neighbors dies, as if by over-population.
//Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
//The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

public class GameOfLife {

	public void gameOfLife(int[][] board) {

		int m = board.length;
		int n = board[0].length;

		int[][] next = new int[m][n];
		// to check the neighbors
		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, -1 },
				{ -1, 1 } };

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				// initialize alive or dead neighbor count
				int alive = 0, dead = 0;
				int curr = board[i][j];

				// go to all possible neighbors and count the alive and dead neighbors
				for (int[] dir : dirs) {
					int x = i + dir[0];
					int y = j + dir[1];

					if (x < 0 || y < 0 || x >= m || y >= n)
						continue;

					if (board[x][y] == 1)
						alive++;
					else
						dead++;
				}

				// apply given conditions to reach the next state
				if (curr == 1) {
					if (alive < 2)
						next[i][j] = 0;
					else if (alive == 2 || alive == 3)
						next[i][j] = 1;
					else if (alive > 3)
						next[i][j] = 0;
				} else {
					if (alive == 3)
						next[i][j] = 1;
				}

			}

		}

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				board[i][j] = next[i][j];
			}
		}

	}
}
