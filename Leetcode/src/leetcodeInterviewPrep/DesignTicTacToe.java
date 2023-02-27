package leetcodeInterviewPrep;

public class DesignTicTacToe {

	int[][] board;
	int n;

	public DesignTicTacToe(int n) {
		board = new int[n][n];
		this.n = n;
	}

	// after each move, check if the the player occupies all values in the row/ col/
	// diagonal / antidiagonal
	public int move(int row, int col, int player) {
		board[row][col] = player;

		if (checkRow(row, player) || checkCol(col, player) || (row == col && checkDiag(player))
				|| (col == n - row - 1 && checkAntiDiag(player)))
			return player;

		return 0;
	}

	// for the row where player made the move, check if all values same
	boolean checkRow(int row, int player) {

		for (int col = 0; col < n; col++) {
			if (board[row][col] != player)
				return false;
		}

		return true;
	}

	// for the column check if all values same
	boolean checkCol(int col, int player) {

		for (int row = 0; row < n; row++) {
			if (board[row][col] != player)
				return false;
		}

		return true;
	}

	boolean checkDiag(int player) {

		for (int row = 0; row < n; row++) {
			if (board[row][row] != player)
				return false;
		}

		return true;
	}

	boolean checkAntiDiag(int player) {

		for (int row = 0; row < n; row++) {
			if (board[row][n - row - 1] != player)
				return false;
		}

		return true;
	}

}
