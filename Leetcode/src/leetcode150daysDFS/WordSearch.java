package leetcode150daysDFS;

//Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

public class WordSearch {

	public boolean exist(char[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		return existDP(board, word, visited);
	}

	boolean existDP(char[][] board, String word, boolean[][] visited) {

		int index = 0;

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[0].length; j++) {

				if (dfs(i, j, board, word, visited, 0))
					return true;
			}
		}

		return false;
	}

	boolean dfs(int i, int j, char[][] board, String word, boolean[][] visited, int index) {

		if (index == word.length())
			return true;

		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]
				|| word.charAt(index) != board[i][j])
			return false;

		visited[i][j] = true;

		if (dfs(i + 1, j, board, word, visited, index + 1))
			return true;
		if (dfs(i, j + 1, board, word, visited, index + 1))
			return true;
		if (dfs(i - 1, j, board, word, visited, index + 1))
			return true;
		if (dfs(i, j - 1, board, word, visited, index + 1))
			return true;

		visited[i][j] = false;
		return false;
	}

}
