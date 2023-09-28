package leetcode150daysMatrix;

import java.util.HashSet;

public class ValidSudoku {

	class Solution {
		public boolean isValidSudoku(char[][] board) {

			for (int i = 0; i < 9; i++) {
				if (!checkRow(board, i))
					return false;
			}

			for (int i = 0; i < 9; i++) {
				if (!checkCol(board, i))
					return false;
			}

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
					if (set.contains(ch) && ch != '.')
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

			for (; row < lastrow; row++) {

				for (int j = col; j < lastcol; j++) {
					char ch = board[row][j];
					if (Character.isDigit(ch)) {
						if (set.contains(ch))
							return false;
						set.add(board[row][j]);
					}

				}
			}

			return true;
		}
	}

}
