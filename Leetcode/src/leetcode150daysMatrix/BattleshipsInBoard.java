package leetcode150daysMatrix;

//Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.
//
//Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).

public class BattleshipsInBoard {

	public int countBattleships(char[][] board) {
		int num = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				if (board[i][j] == 'X') {
					if (i == 0 && j == 0)
						num++;
					else if (i == 0) {
						if (board[i][j - 1] != 'X')
							num++;
					} else if (j == 0) {
						if (board[i - 1][j] != 'X')
							num++;
					} else {
						if (board[i - 1][j] != 'X' && board[i][j - 1] != 'X')
							num++;
					}
				}

			}
		}

		return num;
	}

}
