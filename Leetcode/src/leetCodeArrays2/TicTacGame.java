package leetCodeArrays2;

public class TicTacGame {

	public String tictactoe(int[][] moves) {

		int[][] board = new int[3][3]; // create temporary board

		for (int i = 0; i < moves.length; i++) { // scan through all the moves made
			int move[] = moves[i];

			if ((i % 2) == 0) // see if move was made by A or B, and
				board[move[0]][move[1]] = 1; // of move was made by A, write 1 on that cell
			else
				board[move[0]][move[1]] = -1; // else -1
		}

		for (int i = 0; i < 3; i++) {

			int sum = 0;

			for (int j = 0; j < 3; j++) { // check for sum of the elements of row i
				sum += board[i][j];
			}

			if (sum == 3) // if sum == 3 or -3, we have an answer
				return "A";
			if (sum == -3)
				return "B";

			sum = 0;
			for (int j = 0; j < 3; j++) { // check for the sum of ith column
				sum += board[j][i];
			}

			if (sum == 3)
				return "A";
			if (sum == -3)
				return "B";

		}

		int diag = board[0][0] + board[1][1] + board[2][2]; // check both the diagonals
		int revdiag = board[0][2] + board[1][1] + board[2][0];

		if (diag == 3)
			return "A";
		if (diag == -3)
			return "B";
		if (revdiag == 3)
			return "A";
		if (revdiag == -3)
			return "B";

		if (moves.length < 9) // if moves < 9 means still new moves can be made, so return Pending
			return "Pending";
		else
			return "Draw"; // else return draw

	}
}
