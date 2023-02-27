package leetcodeInterviewPrep;

import java.util.HashSet;

//Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
//Each row must contain the digits 1-9 without repetition.
//Each column must contain the digits 1-9 without repetition.
//Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
//Note:
//
//A Sudoku board (partially filled) could be valid but is not necessarily solvable.
//Only the filled cells need to be validated according to the mentioned rules.

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		// check in all rows
		for (int i = 0; i < 9; i++) {
			if (!checkRow(board, i))
				return false;
		}

		// check in all columns
		for (int i = 0; i < 9; i++) {
			if (!checkCol(board, i))
				return false;
		}

		// check in each box
		// increment row and col by 3 to reach the starting point of next box
		for (int i = 0; i < 9; i += 3) {

			for (int j = 0; j < 9; j += 3) {

				if (!checkBox(board, i, j))
					return false;
			}
		}

		return true;

	}

	boolean checkRow(char[][] board, int row) {

		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			char ch = board[row][i];
			if (Character.isDigit(ch)) {
				if (set.contains(ch))
					return false;
				set.add(ch);
			}
		}

		return true;
	}

	boolean checkCol(char[][] board, int col) {

		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			char ch = board[i][col];
			if (Character.isDigit(ch)) {
				if (set.contains(ch))
					return false;
				set.add(ch);
			}
		}

		return true;
	}

	boolean checkBox(char[][] board, int row, int col) {

		HashSet<Character> set = new HashSet<>();
		int lastrow = row + 3;
		int lastcol = col + 3;
		for (int i = row; i < lastrow; i++) {

			for (int j = col; j < lastcol; j++) {

				char ch = board[i][j];
				if (Character.isDigit(ch)) {
					if (set.contains(ch))
						return false;
					set.add(ch);
				}
			}
		}

		return true;
	}
}
