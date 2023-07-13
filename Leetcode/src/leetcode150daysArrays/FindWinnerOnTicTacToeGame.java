package leetcode150daysArrays;

//Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:
//
//Players take turns placing characters into empty squares ' '.
//The first player A always places 'X' characters, while the second player B always places 'O' characters.
//'X' and 'O' characters are always placed into empty squares, never on filled ones.
//The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
//The game also ends if all squares are non-empty.
//No more moves can be played if the game is over.
//Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".
//
//You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.

public class FindWinnerOnTicTacToeGame {

	public String tictactoe(int[][] moves) {

		int[][] board = new int[3][3];

		for (int i = 0; i < moves.length; i++) {
			int move[] = moves[i];

			if ((i % 2) == 0)
				board[move[0]][move[1]] = 1;
			else
				board[move[0]][move[1]] = -1;
		}

		for (int i = 0; i < 3; i++) {

			int sum = 0;
			// vertical sum
			for (int j = 0; j < 3; j++) {
				sum += board[i][j];
			}

			if (sum == 3)
				return "A";
			if (sum == -3)
				return "B";

			sum = 0;
			for (int j = 0; j < 3; j++) {
				sum += board[j][i];
			}

			if (sum == 3)
				return "A";
			if (sum == -3)
				return "B";

		}

		int diag = board[0][0] + board[1][1] + board[2][2];
		int revdiag = board[0][2] + board[1][1] + board[2][0];

		if (diag == 3)
			return "A";
		if (diag == -3)
			return "B";
		if (revdiag == 3)
			return "A";
		if (revdiag == -3)
			return "B";

		if (moves.length < 9)
			return "Pending";
		else
			return "Draw";

	}

}
